package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.macro.mall.tiny.common.exception.Asserts;
import com.macro.mall.tiny.modules.oms.dao.PortalOrderDao;
import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderDetail;
import com.macro.mall.tiny.modules.oms.entity.ConfirmOrderResult;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderSetting;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.oms.service.OmsOrderSettingService;
import com.macro.mall.tiny.modules.oms.service.OmsPortalOrderService;
import com.macro.mall.tiny.modules.pms.service.PmsSkuStockService;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistory;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;
import com.macro.mall.tiny.modules.sms.service.SmsCouponHistoryService;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberReceiveAddress;
import com.macro.mall.tiny.modules.ums.service.UmsMemberCouponService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberReceiveAddressService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
//
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;

    @Autowired
    private com.macro.mall.tiny.modules.oms.service.OmsOrderService omsOrderService;

    @Autowired
    private UmsMemberCouponService memberCouponService;

    @Autowired
    private PortalOrderDao portalOrderDao;


    @Autowired
    private PmsSkuStockService pmsSkuService;

    @Autowired
    private SmsCouponHistoryService couponService;

    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    @Override
    public ConfirmOrderResult generateConfirmOrder(List<Long> cartIds) {

        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        //UmsMember currentMember = memberService.getCurrentMember();
        UmsMember currentMember = new UmsMember().setId(1L).setIntegration(5000);
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(), cartIds);
        result.setCartPromotionItemList(cartPromotionItemList);

        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.memberReceiveAddressList();
        result.setMemberReceiveAddressList(memberReceiveAddressList);

        //获取用户可用优惠券列表

        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);


        return null;
    }

    @Override
    public int deleteOrder(Long orderId) {
        UmsMember umsMember = new UmsMember().setId(1L);
        OmsOrder omsOrder = omsOrderService.getById(orderId);

        if (!omsOrder.getMemberId().equals(umsMember.getId())) {
            Asserts.fail("不能删除他人订单！");
        }
        if (omsOrder.getStatus() == 3 || omsOrder.getStatus() == 4) {
            omsOrder.setDeleteStatus(1);
            omsOrderService.updateById(omsOrder);
        } else {
            Asserts.fail("只能删除已完成或已关闭的订单！");
        }

        return 1;
    }

    @Transactional
    @Override
    public Integer cancelTimeOutOrder() {
        Integer count = 0;
        OmsOrderSetting omsOrderSetting = omsOrderSettingService.getById(1L);
        //查询超时未支付的订单
        List<OmsOrderDetail> timeOutOrders = portalOrderDao.getTimeOutOrders(omsOrderSetting.getNormalOrderOvertime());
        if (CollectionUtils.isEmpty(timeOutOrders)) {
            return count;
        }
        //修改订单状态为取消
        List<Long> ids = new ArrayList<>();
        timeOutOrders.stream().forEach(e -> {
            ids.add(e.getId());
        });
        portalOrderDao.updateOrderStatus(ids, 4);


        for (OmsOrderDetail timeOutOrder : timeOutOrders) {
            //解除订单库存锁定
            pmsSkuService.releaseSkuStockLock(timeOutOrder.getOrderItemList());


            //修改优惠券使用状态
            updateCouponStatus(timeOutOrder.getCouponId(), timeOutOrder.getMemberId(), 0);
            //返还使用积分
            if (timeOutOrder.getUseIntegration() != null) {
                UmsMember member = memberService.getById(timeOutOrder.getMemberId());
                memberService.updateIntegration(timeOutOrder.getMemberId(), member.getIntegration() + timeOutOrder.getUseIntegration());
            }

        }
        return count;
    }

    @Override
    public void confirmReceiveOrder(Long orderId) {
        UmsMember umsMember = new UmsMember().setId(1L);
        OmsOrder omsOrder = omsOrderService.getById(orderId);

        if (!omsOrder.getMemberId().equals(umsMember.getId())) {
            Asserts.fail("不能确认他人订单！");
        }

        //TODO 应该定义枚举类 来避免使用魔法值
        if (omsOrder.getStatus() != 2) {
            Asserts.fail("该订单还未发货！");
        }

        omsOrder.setStatus(3);
        omsOrder.setConfirmStatus(1);
        omsOrder.setReceiveTime(LocalDateTime.now());
        omsOrderService.updateById(omsOrder);


    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {

    }

    /**
     * 将优惠券信息更改为指定状态
     * 优惠券id
     * 会员id
     * 0 未使用  ; 1 已使用
     *
     * @param couponId
     * @param memberId
     * @param useStatus
     */
    private void updateCouponStatus(Long couponId, Long memberId, int useStatus) {
        if (couponId == null) {
            return;
        }
        List<SmsCouponHistory> couponHistoryList = couponService.list(
                new LambdaQueryWrapper<SmsCouponHistory>()
                        .eq(SmsCouponHistory::getCouponId, couponId)
                        .eq(SmsCouponHistory::getMemberId, memberId)
                        .eq(SmsCouponHistory::getUseStatus, 0));


        if (!CollectionUtils.isEmpty(couponHistoryList)) {
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(LocalDateTime.now());
            couponHistory.setUseStatus(useStatus);
            couponService.updateById(couponHistory);
        }

    }
}

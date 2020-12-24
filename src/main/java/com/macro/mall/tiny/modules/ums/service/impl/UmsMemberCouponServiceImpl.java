package com.macro.mall.tiny.modules.ums.service.impl;

import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.sms.dao.SmsCouponHistoryDao;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponProductRelation;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.service.UmsMemberCouponService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UmsMemberCouponServiceImpl implements UmsMemberCouponService {

    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;

    @Override
    public List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type) {
        // UmsMember currentMember = memberService.getCurrentMember();
        UmsMember currentMember = new UmsMember().setId(1L).setIntegration(5000);
        LocalDateTime now = LocalDateTime.now();
        //获取该用户所有优惠券
        List<SmsCouponHistoryDetail> allList = couponHistoryDao.getDetailList(currentMember.getId());
        //根据优惠券使用类型来判断优惠券是否可用
        List<SmsCouponHistoryDetail> enableList = new ArrayList<>();
        List<SmsCouponHistoryDetail> disableList = new ArrayList<>();
        for (SmsCouponHistoryDetail couponHistoryDetail : allList) {
            Integer useType = couponHistoryDetail.getCoupon().getUseType();
            Double minPoint = couponHistoryDetail.getCoupon().getMinPoint();
            LocalDateTime endTime = couponHistoryDetail.getCoupon().getEndTime();
            if (useType.equals(0)) {
                //0->全场通用
                //判断是否满足优惠起点
                //计算购物车商品的总价
                Double totalAmount = calcTotalAmount(cartItemList);
                if (now.isBefore(endTime) && totalAmount - (minPoint).intValue() >= 0) {
                    enableList.add(couponHistoryDetail);
                } else {
                    disableList.add(couponHistoryDetail);
                }
            } else if (useType.equals(2)) {
                //2->指定商品
                //计算指定商品的总价
                List<Long> productIds = new ArrayList<>();
                for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                    productIds.add(productRelation.getProductId());
                }
                BigDecimal totalAmount = calcTotalAmountByProductId(cartItemList, productIds);
                if (now.isBefore(endTime) && totalAmount.intValue() > 0 && totalAmount.subtract(BigDecimal.valueOf(minPoint)).intValue() >= 0) {
                    enableList.add(couponHistoryDetail);
                } else {
                    disableList.add(couponHistoryDetail);
                }

            }

        }

        if (type.equals(1)) {
            return enableList;
        } else {
            return disableList;
        }
    }

    private BigDecimal calcTotalAmountByProductId(List<CartPromotionItem> cartItemList, List<Long> productIds) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem cartItem : cartItemList) {
            if (productIds.contains(cartItem.getProductId())) {
                Double realPrice = cartItem.getPrice() - cartItem.getReduceAmount().doubleValue();
                total = total.add(BigDecimal.valueOf(realPrice * cartItem.getQuantity()));
            }
        }
        return total;

    }

    private Double calcTotalAmount(List<CartPromotionItem> cartItemList) {
        Double total = null;
        for (CartPromotionItem item : cartItemList) {
            double realPrice = item.getPrice() - (item.getReduceAmount()).doubleValue();
            total += realPrice * (item.getQuantity());
        }
        return total;
    }
}

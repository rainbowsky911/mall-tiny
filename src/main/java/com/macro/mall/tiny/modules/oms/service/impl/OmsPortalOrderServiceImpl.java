package com.macro.mall.tiny.modules.oms.service.impl;

import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.entity.ConfirmOrderResult;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.oms.service.OmsPortalOrderService;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberReceiveAddress;
import com.macro.mall.tiny.modules.ums.service.UmsMemberCouponService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberReceiveAddressService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsPortalOrderServiceImpl  implements OmsPortalOrderService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;

    @Autowired
    private UmsMemberCouponService memberCouponService;


    @Override
    public ConfirmOrderResult generateConfirmOrder(List<Long> cartIds) {

        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        //UmsMember currentMember = memberService.getCurrentMember();
        UmsMember currentMember =new UmsMember().setId(1L).setIntegration(5000);
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),cartIds);
        result.setCartPromotionItemList(cartPromotionItemList);

        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.memberReceiveAddressList();
        result.setMemberReceiveAddressList(memberReceiveAddressList);

        //获取用户可用优惠券列表

        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);


        return null;
    }
}

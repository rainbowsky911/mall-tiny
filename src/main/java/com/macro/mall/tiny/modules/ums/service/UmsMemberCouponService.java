package com.macro.mall.tiny.modules.ums.service;

import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;

import java.util.List;

/**
 * 用户优惠券管理Service
 */
public interface UmsMemberCouponService {


    /**
     * 根据购物车信息获取可用优惠券
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);
}

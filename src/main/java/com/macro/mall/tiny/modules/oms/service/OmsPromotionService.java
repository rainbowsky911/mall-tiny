package com.macro.mall.tiny.modules.oms.service;

import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;

import java.util.List;

/**
 *
 * 促销管理接口类
 * @author 51473
 */
public interface OmsPromotionService {


    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}

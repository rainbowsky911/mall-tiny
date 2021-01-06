package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.entity.CartProduct;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车表(OmsCartItem)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:49
 */
public interface OmsCartItemService extends IService<OmsCartItem> {

    /**
     * 添加商品到购物车 有则添加更新数量 没有则添加
     *
     * @param cartItem
     * @return
     */
    @Transactional
    int add(OmsCartItem cartItem);


    /**
     * 获取包含促销活动信息的购物车列表
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * 修改购物车商品数量
     *
     * @param id
     * @param quantity
     * @return
     */
    int updateQuantity(Long id, Integer quantity);

    /**
     * 清空购物车
     *
     * @return
     */
    int clearOmsCartItems();

    /**
     * 删除购物车某个商品
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改购物车中商品的规格
     *
     * @param cartItem
     * @return
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    CartProduct getCartProduct(Long productId);

    /**
     * 根据会员ID获取购物车列表
     * @param memberId
     * @return
     */
    List<OmsCartItem> getOmsCartByUserId(long memberId);
}
package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

/**
 * 购物车表(OmsCartItem)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:49
 */
public interface OmsCartItemService extends IService<OmsCartItem> {

    /**
     * 添加商品到购物车 有则添加更新数量 没有则添加
     * @param cartItem
     * @return
     */
    @Transactional
    int add(OmsCartItem cartItem);
}
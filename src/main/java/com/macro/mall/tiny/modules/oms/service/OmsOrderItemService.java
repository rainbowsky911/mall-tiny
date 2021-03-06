package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;

/**
 * 订单中所包含的商品(OmsOrderItem)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
public interface OmsOrderItemService extends IService<OmsOrderItem> {


    /**
     * 解除取消订单的库存锁定
     */

}
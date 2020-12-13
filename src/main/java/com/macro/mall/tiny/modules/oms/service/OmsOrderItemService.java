package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单中所包含的商品(OmsOrderItem)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
public interface OmsOrderItemService extends IService<OmsOrderItem> {


}
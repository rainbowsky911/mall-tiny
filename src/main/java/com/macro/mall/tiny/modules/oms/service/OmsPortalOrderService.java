package com.macro.mall.tiny.modules.oms.service;

import com.macro.mall.tiny.modules.oms.entity.ConfirmOrderResult;

import java.util.List;

/**
 * 前台订单管理
 */
public interface OmsPortalOrderService {


    /**
     * 根据用户购物车信息生成确认单信息
     *
     * @param cartIds
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);
}

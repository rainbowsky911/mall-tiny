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


    /**
     * 根据orderId删除订单信息
     * @param orderId
     * @return
     */
    int deleteOrder(Long orderId);


    /**
     * 自动取消超时订单
     * @return
     */
    Integer cancelTimeOutOrder();

    /**
     * 用户确认收货
     * @param orderId
     */
    void confirmReceiveOrder(Long orderId);


    /**
     * 发送延时消息 自动取消超时订单
     * @param orderId
     */
    void sendDelayMessageCancelOrder(Long orderId);
}

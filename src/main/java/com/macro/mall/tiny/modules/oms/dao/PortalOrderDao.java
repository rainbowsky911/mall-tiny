package com.macro.mall.tiny.modules.oms.dao;


import com.macro.mall.tiny.modules.oms.dto.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单前台自定义Dao
 * @author 51473
 */
public interface PortalOrderDao {


    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * 批量修改订单状态
     * @param ids
     * @param status
     * @return
     */
    int updateOrderStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);
}

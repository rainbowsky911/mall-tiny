package com.macro.mall.tiny.modules.oms.dto;

import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 包含商品信息的订单详情
 * @author 51473
 */
@Data
@Accessors(chain = true)
public class OmsOrderDetail  extends OmsOrder {


    private List<OmsOrderItem> orderItemList;
}

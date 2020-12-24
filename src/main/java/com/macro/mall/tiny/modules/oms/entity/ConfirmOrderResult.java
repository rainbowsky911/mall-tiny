package com.macro.mall.tiny.modules.oms.entity;

import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;
import com.macro.mall.tiny.modules.ums.entity.UmsIntegrationConsumeSetting;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberReceiveAddress;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * 确认单信息封装
 */
@Data
@Accessors(chain = true)
public class ConfirmOrderResult {


    //包含优惠信息的购物车信息
    private List<CartPromotionItem> cartPromotionItemList;
    //用户收货地址列表
    private List<UmsMemberReceiveAddress> memberReceiveAddressList;
    //用户可用优惠券列表
    private List<SmsCouponHistoryDetail> couponHistoryDetailList;
    //积分使用规则
    private UmsIntegrationConsumeSetting integrationConsumeSetting;
    //会员持有的积分
    private Integer memberIntegration;
    //计算的金额
    private CalcAmount calcAmount;


    @Data
    @Accessors(chain = true)
    static class CalcAmount {

        //订单商品总金额
        private BigDecimal totalAmount;
        //运费
        private BigDecimal freightAmount;
        //活动优惠
        private BigDecimal promotionAmount;
        //应付金额
        private BigDecimal payAmount;
    }
}

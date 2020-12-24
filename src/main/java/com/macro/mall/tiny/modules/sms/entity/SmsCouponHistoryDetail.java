package com.macro.mall.tiny.modules.sms.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 优惠券领取历史封装
 */
@Data
@Accessors(chain = true)
public class SmsCouponHistoryDetail extends SmsCouponHistory {

    //相关优惠券信息
    private SmsCoupon coupon;
    //优惠券关联商品
    private List<SmsCouponProductRelation> productRelationList;
    //优惠券关联商品分类
    private List<SmsCouponProductCategoryRelation> categoryRelationList;

}

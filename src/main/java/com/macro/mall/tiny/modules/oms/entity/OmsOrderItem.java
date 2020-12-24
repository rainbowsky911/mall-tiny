package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 订单中所包含的商品(OmsOrderItem)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsOrderItem extends Model<OmsOrderItem> {

    private Long id;
    //订单id
    private Long orderId;
    //订单编号
    private String orderSn;

    private Long productId;

    private String productPic;

    private String productName;

    private String productBrand;

    private String productSn;
    //销售价格
    private Double productPrice;
    //购买数量
    private Integer productQuantity;
    //商品sku编号
    private Long productSkuId;
    //商品sku条码
    private String productSkuCode;
    //商品分类id
    private Long productCategoryId;
    //商品促销名称
    private String promotionName;
    //商品促销分解金额
    private Double promotionAmount;
    //优惠券优惠分解金额
    private Double couponAmount;
    //积分优惠分解金额
    private Double integrationAmount;
    //该商品经过优惠后的分解金额
    private Double realAmount;

    private Integer giftIntegration;

    private Integer giftGrowth;
    //商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
    private String productAttr;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
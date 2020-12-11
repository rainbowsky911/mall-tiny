package com.macro.mall.tiny.modules.sms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 优惠券和产品分类关系表(SmsCouponProductCategoryRelation)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:43:57
 */
@SuppressWarnings("serial")
public class SmsCouponProductCategoryRelation extends Model<SmsCouponProductCategoryRelation> {

    private Long id;

    private Long couponId;

    private Long productCategoryId;
    //产品分类名称
    private String productCategoryName;
    //父分类名称
    private String parentCategoryName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

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
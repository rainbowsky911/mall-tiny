package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 产品阶梯价格表(只针对同商品)(PmsProductLadder)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@SuppressWarnings("serial")
public class PmsProductLadder extends Model<PmsProductLadder> {

    private Long id;

    private Long productId;
    //满足的商品数量
    private Integer count;
    //折扣
    private Double discount;
    //折后价格
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
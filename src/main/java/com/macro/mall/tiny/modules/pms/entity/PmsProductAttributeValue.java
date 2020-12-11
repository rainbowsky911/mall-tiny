package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 存储产品参数信息的表(PmsProductAttributeValue)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
@SuppressWarnings("serial")
public class PmsProductAttributeValue extends Model<PmsProductAttributeValue> {

    private Long id;

    private Long productId;

    private Long productAttributeId;
    //手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
    private String value;


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

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
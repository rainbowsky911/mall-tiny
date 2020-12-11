package com.macro.mall.tiny.modules.cms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 优选专区和产品关系表(CmsPrefrenceAreaProductRelation)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@SuppressWarnings("serial")
public class CmsPrefrenceAreaProductRelation extends Model<CmsPrefrenceAreaProductRelation> {

    private Long id;

    private Long prefrenceAreaId;

    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrefrenceAreaId() {
        return prefrenceAreaId;
    }

    public void setPrefrenceAreaId(Long prefrenceAreaId) {
        this.prefrenceAreaId = prefrenceAreaId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
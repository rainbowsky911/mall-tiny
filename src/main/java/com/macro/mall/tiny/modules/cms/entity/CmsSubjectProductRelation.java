package com.macro.mall.tiny.modules.cms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 专题商品关系表(CmsSubjectProductRelation)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:20:16
 */
@SuppressWarnings("serial")
public class CmsSubjectProductRelation extends Model<CmsSubjectProductRelation> {

    private Long id;

    private Long subjectId;

    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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
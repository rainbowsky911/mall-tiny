package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 产品属性分类表(PmsProductAttributeCategory)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
//@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsProductAttributeCategory extends Model<PmsProductAttributeCategory> {

    private Long id;

    private String name;
    //属性数量
    private Integer attributeCount;
    //参数数量
    private Integer paramCount;


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
package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品属性参数表(PmsProductAttribute)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
//@SuppressWarnings("serial")
@Data
public class PmsProductAttribute extends Model<PmsProductAttribute> {

    private Long id;

    private Long productAttributeCategoryId;

    private String name;
    //属性选择类型：0->唯一；1->单选；2->多选
    private Integer selectType;
    //属性录入方式：0->手工录入；1->从列表中选取
    private Integer inputType;
    //可选值列表，以逗号隔开
    private String inputList;
    //排序字段：最高的可以单独上传图片
    private Integer sort;
    //分类筛选样式：1->普通；1->颜色
    private Integer filterType;
    //检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
    private Integer searchType;
    //相同属性产品是否关联；0->不关联；1->关联
    private Integer relatedStatus;
    //是否支持手动新增；0->不支持；1->支持
    private Integer handAddStatus;
    //属性的类型；0->规格；1->参数
    private Integer type;




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
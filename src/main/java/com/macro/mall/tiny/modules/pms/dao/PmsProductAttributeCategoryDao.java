package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import com.macro.mall.tiny.modules.ums.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 产品属性分类表(PmsProductAttributeCategory)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
public interface PmsProductAttributeCategoryDao extends BaseMapper<PmsProductAttributeCategory> {

    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();


}
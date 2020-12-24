package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;

import java.util.List;

/**
 * 产品分类(PmsProductCategory)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
public interface PmsProductCategoryDao extends BaseMapper<PmsProductCategory> {

    /**
     * 获取分类及其子分类
     *
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> getCategoryListWithChild();
}
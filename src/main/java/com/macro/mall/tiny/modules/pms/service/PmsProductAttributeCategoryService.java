package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import com.macro.mall.tiny.modules.ums.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 产品属性分类表(PmsProductAttributeCategory)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {


    /**获取包含属性的商品属性分类
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
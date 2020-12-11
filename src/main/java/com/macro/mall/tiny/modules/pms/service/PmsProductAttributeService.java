package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;

import java.util.List;

/**
 * 商品属性参数表(PmsProductAttribute)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {


    /**
     * 获取商品分类对应属性
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
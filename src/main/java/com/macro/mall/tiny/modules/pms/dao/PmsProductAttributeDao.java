package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性参数表(PmsProductAttribute)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
public interface PmsProductAttributeDao extends BaseMapper<PmsProductAttribute> {


    List<ProductAttrInfo> getProductAttrInfo(@Param("productCategoryId") Long productCategoryId);
}
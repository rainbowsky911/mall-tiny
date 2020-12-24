package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.dto.PmsProductAttributeParam;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

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
     *
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);


    /**
     * 商品规格列表
     *
     * @param id
     * @param pageSize
     * @param pageNum
     * @param type
     * @return
     */
    Page<PmsProductAttribute> getList(Long id, Integer pageSize, Integer pageNum, Integer type);


    /**
     * 修改商品属性
     *
     * @param id
     * @param pmsProductAttributeParam
     * @return
     */
    @Transactional
    int updatePmsProductAttribute(Long id, PmsProductAttributeParam pmsProductAttributeParam);


    @Transactional
    int create(PmsProductAttributeParam productAttributeParam);
}
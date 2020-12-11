package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductCategoryAttributeRelationDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategoryAttributeRelation;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryAttributeRelationService;
import org.springframework.stereotype.Service;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）(PmsProductCategoryAttributeRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
@Service("pmsProductCategoryAttributeRelationService")
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationDao, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}
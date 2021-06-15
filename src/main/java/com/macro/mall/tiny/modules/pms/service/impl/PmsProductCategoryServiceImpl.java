package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductCategoryDao;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryParam;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategoryAttributeRelation;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeCategoryService;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryAttributeRelationService;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryService;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品分类(PmsProductCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
@Service("pmsProductCategoryService")
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryDao, PmsProductCategory> implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Autowired
    private PmsProductService productService;

    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @Autowired
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    @Override
    public Page<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        Page<PmsProductCategory> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProductCategory> lambda = wrapper.lambda();
        if (ObjectUtil.isNotNull(parentId)) {
            lambda.eq(PmsProductCategory::getParentId, parentId);
        }
        return page(page, wrapper);
    }

    @Override
    public int updateNavStatus(Long ids, Integer navStatus) {
        LambdaUpdateWrapper<PmsProductCategory> lambda = new LambdaUpdateWrapper<>();
        lambda.set(PmsProductCategory::getNavStatus, navStatus.byteValue());
        lambda.eq(PmsProductCategory::getId, ids);
        boolean update = update(lambda);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateShowStatus(Long ids, Integer showStatus) {
        LambdaUpdateWrapper<PmsProductCategory> lambda = new LambdaUpdateWrapper<>();
        lambda.set(PmsProductCategory::getNavStatus, showStatus.byteValue());
        lambda.eq(PmsProductCategory::getId, ids);
        boolean update = update(lambda);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> getCategoryListWithChild() {
        return productCategoryDao.getCategoryListWithChild();
    }

    @Override
    @Transactional
    public int updateCategory(Long id, PmsProductCategoryParam param) {

        //更新分类要更新商品中的名称
        PmsProductCategory productCategory =new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(param,productCategory);

        PmsProduct pmsProduct =new PmsProduct();
        pmsProduct.setProductCategoryName(productCategory.getName());
        productService.lambdaUpdate()
                .set(PmsProduct::getProductCategoryName,productCategory.getName())
                .eq(PmsProduct::getProductCategoryId,id);

        if(ObjectUtil.isEmpty(param.getProductAttributeIdList())) {
            LambdaQueryWrapper<PmsProductCategoryAttributeRelation> wrapper = new LambdaQueryWrapper<PmsProductCategoryAttributeRelation>();
            wrapper.eq(PmsProductCategoryAttributeRelation::getProductCategoryId,id);
            pmsProductCategoryAttributeRelationService .remove(wrapper);
            insertRelationList(id,param.getProductAttributeIdList());
        }else {
            LambdaQueryWrapper<PmsProductCategoryAttributeRelation> wrapper = new LambdaQueryWrapper<PmsProductCategoryAttributeRelation>();
            wrapper.eq(PmsProductCategoryAttributeRelation::getProductCategoryId,id);
            pmsProductCategoryAttributeRelationService .remove(wrapper);
            insertRelationList(id,param.getProductAttributeIdList());
        }

        return productCategoryDao.updateCategory(productCategory);
    }
    /**
     * 批量插入商品分类与筛选属性关系表
     * @param productCategoryId 商品分类id
     * @param productAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelation> relationList = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        pmsProductCategoryAttributeRelationService.saveBatch(relationList);
    }

}
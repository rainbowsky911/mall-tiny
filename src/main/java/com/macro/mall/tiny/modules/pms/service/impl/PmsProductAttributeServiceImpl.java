package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductAttributeDao;
import com.macro.mall.tiny.modules.pms.dto.PmsProductAttributeParam;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeCategoryService;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性参数表(PmsProductAttribute)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
@Service("pmsProductAttributeService")
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeDao, PmsProductAttribute> implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeDao pmsProductAttributeDao;

    @Autowired
    private PmsProductAttributeCategoryService pmsProductCategoryCategoryService;

    @Override
    public List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return pmsProductAttributeDao.getProductAttrInfo(productCategoryId);
    }

    @Override
    public Page<PmsProductAttribute> getList(Long id, Integer pageSize, Integer pageNum, Integer type) {
        Page<PmsProductAttribute> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper <PmsProductAttribute>lambdaQueryWrapper =new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(PmsProductAttribute::getId,id);
        lambdaQueryWrapper.eq(PmsProductAttribute::getType,type);
         return  page(page,lambdaQueryWrapper);
    }


    @Override
    public int updatePmsProductAttribute(Long id, PmsProductAttributeParam pmsProductAttributeParam) {
        PmsProductAttribute pmsProductAttribute =new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeParam,pmsProductAttribute);
        pmsProductAttribute.setId(id);
        boolean update = updateById(pmsProductAttribute);
        if (update) {
            return  1;
        }else {
            return 0;
        }
    }

    @Override
    public int create(PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute pmsProductAttribute =new PmsProductAttribute();
        BeanUtils.copyProperties(productAttributeParam,pmsProductAttribute);

        boolean saveStatus = save(pmsProductAttribute);
        PmsProductAttributeCategory pmsProductAttributeCategory =
                pmsProductCategoryCategoryService.getById(pmsProductAttribute.getProductAttributeCategoryId());

        //更新商品属性以后要更新商品属性分类数量

        if(pmsProductAttribute.getType()==0){
            pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount()+1);
        }else if(pmsProductAttribute.getType()==1){
            pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount()+1);
        }


        pmsProductCategoryCategoryService.updateById(pmsProductAttributeCategory);
       /* new LambdaUpdateWrapper<PmsProductAttributeCategory>()
                .set(PmsProductAttributeCategory::getAttributeCount,pmsProductAttributeCategory.getAttributeCount()+1)
        .eq(PmsProductAttributeCategory::getId,pmsProductAttributeCategory.getId());
        pmsProductCategoryCategoryService.update();*/
        if (saveStatus ){
            return 1;
        }else {
            return 0;
        }
    }
}
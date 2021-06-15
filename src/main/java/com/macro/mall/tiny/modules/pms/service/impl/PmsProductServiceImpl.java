package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceAreaProductRelation;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectProductRelation;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaProductRelationService;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectProductRelationService;
import com.macro.mall.tiny.modules.pms.dao.PmsMemberPriceDao;
import com.macro.mall.tiny.modules.pms.dao.PmsProductDao;
import com.macro.mall.tiny.modules.pms.dto.PmsProductParam;
import com.macro.mall.tiny.modules.pms.dto.PmsProductQueryParam;
import com.macro.mall.tiny.modules.pms.dto.PmsProductResult;
import com.macro.mall.tiny.modules.pms.dto.TestPmsProductParam;
import com.macro.mall.tiny.modules.pms.entity.*;
import com.macro.mall.tiny.modules.pms.service.*;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品信息(PmsProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
@Service("pmsProductService")
public class PmsProductServiceImpl extends ServiceImpl<PmsProductDao, PmsProduct> implements PmsProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductServiceImpl.class);

    @Autowired
    private PmsProductDao pmsProductDao;

    @Autowired
    private PmsMemberPriceDao pmsMemberPriceDao;

    @Autowired
    private PmsProductFullReductionService productFullReductionService;

    @Autowired
    private PmsMemberPriceService pmsMemberPriceService;

    @Autowired
    private PmsSkuStockService pmsSkuService;

    @Autowired
    private PmsProductLadderService productLadderService;

    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @Autowired
    private PmsProductAttributeValueService productAttributeValueService;

    @Autowired
    private CmsSubjectProductRelationService subjectProductRelationService;

    @Autowired
    private CmsPrefrenceAreaProductRelationService prefrenceAreaProductRelationService;

    @Override
    public int create(PmsProductParam pmsProductParam) {
        int count = 0;

        PmsProduct pmsProduct = pmsProductParam;
        pmsProduct.setId(null);
        /**
         * 创建商品
         */
        pmsProductDao.insert(pmsProduct);
        Long productId = pmsProduct.getId();

        /**
         * 会员价格
         */
        pmsMemberPriceService.saveBatch(pmsProductParam.getMemberPriceList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**
         * 库存信息
         */
        pmsSkuService.saveBatch(pmsProductParam.getSkuStockList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**
         * 满减价格
         */
        productFullReductionService.saveBatch(pmsProductParam.getProductFullReductionList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**
         * 阶梯价格
         */
        productLadderService.saveBatch(pmsProductParam.getProductLadderList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**
         * 商品参数 ,自定义商品价格
         */
        productAttributeValueService.saveBatch(pmsProductParam.getProductAttributeValueList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**
         * 关联专题
         */
        subjectProductRelationService.saveBatch(pmsProductParam.getSubjectProductRelationList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));


        /**
         * 关联优选
         */
        prefrenceAreaProductRelationService.saveBatch(pmsProductParam.getPrefrenceAreaProductRelationList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));
        count = 1;
        return count;
    }

    @Override
    public Page<PmsProduct> getList(PmsProductQueryParam productQueryParam,Integer pageSize, Integer pageNum) {
        Page<PmsProduct> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getKeyword()), "key_words", productQueryParam.getKeyword());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getBrandId()), "brand_id", productQueryParam.getBrandId());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getProductSn()), "product_sn", productQueryParam.getProductSn());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getPublishStatus()), "publish_status", productQueryParam.getPublishStatus());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getVerifyStatus()), "verify_status", productQueryParam.getVerifyStatus());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getProductCategoryId()), "product_category_id", productQueryParam.getProductCategoryId());
        return page(page, wrapper);
    }

    @Override
    public int updatePublishStatus(Long ids, Integer publishStatus) {
        boolean updateStaus = update(new LambdaUpdateWrapper<PmsProduct>().set(ObjectUtil.isNotNull(publishStatus), PmsProduct::getPublishStatus, publishStatus)
                .eq(ObjectUtil.isNotNull(ids), PmsProduct::getId, ids));
        if (updateStaus) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        boolean updateStaus = update(new LambdaUpdateWrapper<PmsProduct>().set(ObjectUtil.isNotNull(newStatus), PmsProduct::getNewStatus, newStatus)
                .in(ObjectUtils.isNotEmpty(ids), PmsProduct::getId, ids));
        if (updateStaus) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateRecommendStatus(Long ids, Integer recommendStatus) {
        boolean updateStaus = update(new LambdaUpdateWrapper<PmsProduct>().set(ObjectUtil.isNotNull(recommendStatus), PmsProduct::getRecommandStatus, recommendStatus)
                .eq(ObjectUtil.isNotNull(ids), PmsProduct::getId, ids));
        if (updateStaus) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateProductParam(Long id, PmsProductParam pmsProductParam) {
        PmsProduct product = pmsProductParam;
        pmsProductParam.setId(pmsProductParam.getId());
        this.pmsProductDao.updateById(product);
        Long productId = product.getId();

        int count ;

        pmsMemberPriceService.remove(new LambdaQueryWrapper<PmsMemberPrice>()
                .eq(ObjectUtils.isNotEmpty(id), PmsMemberPrice::getProductId, id));
        /**先删除
         * 再更新会员价格
         */
        pmsMemberPriceService.saveBatch(pmsProductParam.getMemberPriceList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));


        /** 先删除
         * 再更新库存信息
         */
        pmsSkuService.remove(new LambdaQueryWrapper<PmsSkuStock>()
                .eq(ObjectUtils.isNotEmpty(id), PmsSkuStock::getProductId, id));

        pmsSkuService.saveBatch(pmsProductParam.getSkuStockList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**先删除
         * 再更新满减价格
         */
        productFullReductionService.saveBatch(pmsProductParam.getProductFullReductionList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**先删除
         * 再更新阶梯价格
         */

        productLadderService.remove(new LambdaQueryWrapper<PmsProductLadder>()
                .eq(ObjectUtils.isNotEmpty(id), PmsProductLadder::getProductId, id));
        productLadderService.saveBatch(pmsProductParam.getProductLadderList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**先删除
         * 再更新商品参数 ,自定义商品价格
         */


        productAttributeValueService.remove(new LambdaQueryWrapper<PmsProductAttributeValue>()
                .eq(ObjectUtils.isNotEmpty(id), PmsProductAttributeValue::getProductId, id));
        productAttributeValueService.saveBatch(pmsProductParam.getProductAttributeValueList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));

        /**先删除
         * 再更新关联专题
         */
        subjectProductRelationService.remove(new LambdaQueryWrapper<CmsSubjectProductRelation>()
                .eq(ObjectUtils.isNotEmpty(id), CmsSubjectProductRelation::getProductId, id));
        subjectProductRelationService.saveBatch(pmsProductParam.getSubjectProductRelationList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));


        /**先删除
         * 再更新关联优选
         */
        prefrenceAreaProductRelationService.remove(new LambdaQueryWrapper<CmsPrefrenceAreaProductRelation>()
                .eq(ObjectUtils.isNotEmpty(id), CmsPrefrenceAreaProductRelation::getProductId, id));
        prefrenceAreaProductRelationService.saveBatch(pmsProductParam.getPrefrenceAreaProductRelationList()
                .stream()
                .map(p -> p.setProductId(productId)).collect(Collectors.toList()));
        count = 1;
        return count;
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {

        return pmsProductDao.getUpdateInfo(id);
    }

    @Override
    public TestPmsProductParam getUpdateinfo(Long id) {
        return pmsProductDao.getUpdateinfo(id);
    }

    @Override
    public IPage<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        Page<PmsProduct> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        PmsProduct product = new PmsProduct();
        BeanUtils.copyProperties(productQueryParam, product);
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getKeyword()), "key_words", productQueryParam.getKeyword());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getBrandId()), "brand_id", productQueryParam.getBrandId());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getProductSn()), "product_sn", productQueryParam.getProductSn());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getPublishStatus()), "publish_status", productQueryParam.getPublishStatus());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getVerifyStatus()), "verify_status", productQueryParam.getVerifyStatus());
        wrapper.like(ObjectUtils.isNotEmpty(productQueryParam.getProductCategoryId()), "product_category_id", productQueryParam.getProductCategoryId());
        IPage<PmsProduct> userPage = new Page<>(pageNum, pageSize);
        IPage<PmsProduct> selectPage = pmsProductDao.selectPage(userPage, wrapper);
        return selectPage;
    }

    @Override
    public IPage<List<PmsProduct>> getDynamic(Page page, PmsProductQueryParam param) {
        return pmsProductDao.getDynamic(page, param);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        boolean result = update(new LambdaUpdateWrapper<PmsProduct>()
                .set(ObjectUtil.isNotNull(deleteStatus), PmsProduct::getRecommandStatus, deleteStatus)
                .eq(ObjectUtil.isNotNull(ids), PmsProduct::getId, ids));
        return result==true?1:0;
    }

}
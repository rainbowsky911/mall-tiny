package com.macro.mall.tiny.modules.pms.dto;


import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceAreaProductRelation;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectProductRelation;
import com.macro.mall.tiny.modules.pms.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 添加商品信息DTO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct {


    @ApiModelProperty("商品会员价格表")
    private List<PmsMemberPrice> memberPriceList;

    @ApiModelProperty("产品满减设置")
    private List<PmsProductFullReduction> productFullReductionList;


    @ApiModelProperty("产品阶梯价格设置")
    private List<PmsProductLadder> productLadderList;

    @ApiModelProperty("存储产品参数信息")
    private List<PmsProductAttributeValue> productAttributeValueList;

    @ApiModelProperty("sku的库存")
    private List<PmsSkuStock> skuStockList;

    @ApiModelProperty("专题商品关系")
    private List<CmsSubjectProductRelation> subjectProductRelationList;


    @ApiModelProperty("优选专区和产品关系表")
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;


}

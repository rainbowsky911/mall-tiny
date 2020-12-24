package com.macro.mall.tiny.modules.oms.dto;

import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProductFullReduction;
import com.macro.mall.tiny.modules.pms.entity.PmsProductLadder;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 商品的促销信息，包括sku、打折优惠、满减优惠
 */

@Data
@Accessors(chain = true)
public class PromotionProduct extends PmsProduct {


    /**
     * //商品库存信息
     */
    private List<PmsSkuStock> skuStockList;
    /**
     * //商品打折信息
     */
    private List<PmsProductLadder> productLadderList;
    /**
     * //商品满减信息
     */
    private List<PmsProductFullReduction> productFullReductionList;
}

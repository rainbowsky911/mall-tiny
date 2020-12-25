package com.macro.mall.tiny.modules.oms.entity;

import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 */
@Data
@Accessors(chain = true)
public class CartProduct extends PmsProduct {


    private List<PmsProductAttribute> productAttributeList;
    private List<PmsSkuStock> skuStockList;

}

package com.macro.mall.tiny.modules.ums.entity;

import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 */
@Data
@Accessors(chain = true)
public class FlashPromotionProduct extends PmsProduct {
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}

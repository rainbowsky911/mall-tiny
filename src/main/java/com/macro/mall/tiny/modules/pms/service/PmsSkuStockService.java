package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;

import java.util.List;

/**
 * sku的库存(PmsSkuStock)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:42:53
 */
public interface PmsSkuStockService extends IService<PmsSkuStock> {


    /**
     * 根据商品ID查询SKU信息
     *
     * @param id
     * @return
     */
    List<PmsSkuStock> getProductId(Long id);
}
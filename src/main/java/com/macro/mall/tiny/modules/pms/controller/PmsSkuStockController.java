package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import com.macro.mall.tiny.modules.pms.service.PmsSkuStockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku的库存(PmsSkuStock)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:43:00
 */
@RestController
@RequestMapping("sku")
public class PmsSkuStockController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuStockService pmsSkuStockService;


    @ApiOperation("sku信息详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<List<PmsSkuStock>> getProductList(@PathVariable("id") Long id) {
        List<PmsSkuStock> skuStocks = pmsSkuStockService.getProductId(id);
        return CommonResult.success(skuStocks);
    }


    @ApiOperation("更新商品库存")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateRecommendStatus(@PathVariable("id") Long id, @RequestBody List<PmsSkuStock> pmsSkuStock) {

        boolean status = pmsSkuStockService.updateBatchById(pmsSkuStock);
        if (status) {
            return CommonResult.success(pmsSkuStock.size());
        } else {
            return CommonResult.failed();
        }
    }

}
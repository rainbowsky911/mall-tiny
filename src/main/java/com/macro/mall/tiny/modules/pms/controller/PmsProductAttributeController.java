package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsProductAttributeParam;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品属性参数表(PmsProductAttribute)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
@RestController
@RequestMapping("productAttribute")
public class PmsProductAttributeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductAttributeService pmsProductAttributeService;


    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductAttribute> getItem(@PathVariable Long id) {
        PmsProductAttribute productAttribute = pmsProductAttributeService.getById(id);
        return CommonResult.success(productAttribute);
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId) {
        List<ProductAttrInfo> productAttrInfoList = pmsProductAttributeService.getProductAttrInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }


    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductAttribute>> getList(
            @PathVariable ("id") Long id,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam ("type") Integer type) {
        Page<PmsProductAttribute> productAttributeCategoryList =
                pmsProductAttributeService.getList(id,pageSize, pageNum,type);
        return CommonResult.success(CommonPage.restPage(productAttributeCategoryList));
    }


    @ApiOperation("修改商品属性")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAttrbute(
            @PathVariable("id") Long id,
             @RequestBody PmsProductAttributeParam pmsProductAttributeParam) {
        int count = pmsProductAttributeService.updatePmsProductAttribute(id, pmsProductAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductAttributeParam productAttributeParam) {
        int count = pmsProductAttributeService.create(productAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
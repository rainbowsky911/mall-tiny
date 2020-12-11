package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsBrandParam;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import com.macro.mall.tiny.modules.pms.service.PmsBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 品牌表(PmsBrand)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@RestController
@RequestMapping("brand")
public class PmsBrandController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsBrandService pmsBrandService;

    @ApiOperation("商品品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> getList(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsBrand> pmsProductCategoryList = pmsBrandService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(pmsProductCategoryList));
    }

    @ApiOperation("修改品牌制造商状态")
    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateFactoryStatus(@RequestParam("ids")Long ids, @RequestParam("factoryStatus") Integer factoryStatus) {
        int count = pmsBrandService.updateFactoryStatus(ids, factoryStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateShowStatus(@RequestParam("ids") Long ids, @RequestParam("showStatus") Integer showStatus) {
        int count = pmsBrandService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("根据id获取品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> getItem(@PathVariable Long id) {
        PmsBrand pmsBrand = pmsBrandService.getById(id);
        return CommonResult.success(pmsBrand);
    }

    @ApiOperation("修改品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateShowStatus(@PathVariable("id") Long id,
                                        @Validated @RequestBody PmsBrandParam pmsBrandParam) {

        int count  = pmsBrandService.updateBrand(id, pmsBrandParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
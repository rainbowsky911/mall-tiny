package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dao.PmsProductCategoryDao;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品分类(PmsProductCategory)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
@RestController
@RequestMapping("productCategory")
public class PmsProductCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductCategoryService pmsProductCategoryService;

    @Resource
    private PmsProductCategoryDao pmsProductCategoryDao;

    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductCategory>> getList(
            @PathVariable Long parentId,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsProductCategory> pmsProductCategoryList = pmsProductCategoryService.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(pmsProductCategoryList));
    }

    public R selectAll(Page<PmsProductCategory> page, PmsProductCategory pmsProductCategory) {
        return success(this.pmsProductCategoryService.page(page, new QueryWrapper<>(pmsProductCategory)));
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public CommonResult updateNavStatus(@RequestParam("ids") Long ids, @RequestParam("navStatus") Integer navStatus) {

        int count = pmsProductCategoryService.updateNavStatus(ids, navStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam("ids") Long ids, @RequestParam("showStatus") Integer showStatus) {

        int count = pmsProductCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductCategory> getItem(@PathVariable Long id) {
        PmsProductCategory productCategory = pmsProductCategoryService.getById(id);
        return CommonResult.success(productCategory);
    }


    @ApiOperation("获取分类及其子分类")
    @RequestMapping(value = "list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> getCategoryListWithChild() {
        List<PmsProductCategoryWithChildrenItem> list = pmsProductCategoryService.getCategoryListWithChild();
        return CommonResult.success(list);
    }
}
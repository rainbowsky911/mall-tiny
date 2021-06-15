package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.modules.oms.dto.OmsReturnApplyQueryParam;
import com.macro.mall.tiny.modules.oms.dto.OmsUpdateStatusParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单退货申请(OmsOrderReturnApply)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@RestController
@RequestMapping("returnApply")
public class OmsOrderReturnApplyController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderReturnApplyService omsOrderReturnApplyService;


    @ApiOperation("获取退货申请详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getItem(@PathVariable Long id) {
        OmsOrderReturnApplyResult result = omsOrderReturnApplyService.getItem(id);
        return CommonResult.success(result);
    }



    @ApiOperation("退货申请分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrderReturnApply>> getProductList(OmsReturnApplyQueryParam omsReturnApplyQueryParam,
                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<OmsOrderReturnApply> list = omsOrderReturnApplyService.getList(omsReturnApplyQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("修改退货态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    public CommonResult updateStatus(@PathVariable("id") Long id, @RequestBody OmsUpdateStatusParam omsUpdateStatusParam) {

        int count = omsOrderReturnApplyService.updateStatus(id,omsUpdateStatusParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
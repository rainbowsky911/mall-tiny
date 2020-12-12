package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderSetting;
import com.macro.mall.tiny.modules.oms.service.OmsOrderSettingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单设置表(OmsOrderSetting)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:55
 */
@RestController
@RequestMapping("orderSetting")
public class OmsOrderSettingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderSettingService omsOrderSettingService;


    @ApiOperation("查看订单设置详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<OmsOrderSetting> getOmsOrderSetting(
            @PathVariable("id") Long id) {
        OmsOrderSetting orderSetting = omsOrderSettingService.getById(id);
        return CommonResult.success(orderSetting);
    }


    @ApiOperation("修改订单设置")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateOrderSetting(
            @PathVariable("id") Long id, @RequestBody OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        boolean updateStatus = omsOrderSettingService.updateById(orderSetting);
        if (updateStatus) {
            return CommonResult.success(updateStatus);
        }
        return CommonResult.failed();
    }

}
package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
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
@RequestMapping("omsOrderReturnApply")
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

}
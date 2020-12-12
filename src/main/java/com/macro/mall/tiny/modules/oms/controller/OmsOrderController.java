package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import com.macro.mall.tiny.modules.oms.service.OmsOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单表(OmsOrder)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@RestController
@RequestMapping("order")
public class OmsOrderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderService omsOrderService;


    //TODO 后端动态查询的返回格式和前端定义不一致，所以动态查询目前失效

   /* @ApiOperation("订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrder>> getProductList(
             OmsOrderQueryParam orderQueryParam,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<OmsOrder> list = omsOrderService.getList(new Page<>(pageNum, pageSize),orderQueryParam);
        return CommonResult.success(CommonPage.restPage(list.getRecords()));
    }*/

    @ApiOperation("订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrder>> getProductList(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<OmsOrder> list = omsOrderService.getListNormal(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

}
package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.modules.oms.service.OmsOrderItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单中所包含的商品(OmsOrderItem)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@RestController
@RequestMapping("omsOrderItem")
public class OmsOrderItemController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderItemService omsOrderItemService;


}
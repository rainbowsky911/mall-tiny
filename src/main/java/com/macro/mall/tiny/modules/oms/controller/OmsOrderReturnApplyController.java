package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
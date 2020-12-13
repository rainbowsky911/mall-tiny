package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.modules.oms.service.OmsOrderOperateHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单操作历史记录(OmsOrderOperateHistory)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
@RestController
@RequestMapping("omsOrderOperateHistory")
public class OmsOrderOperateHistoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;


}
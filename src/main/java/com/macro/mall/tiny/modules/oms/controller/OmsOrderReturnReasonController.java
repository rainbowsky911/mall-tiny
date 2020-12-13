package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnReason;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnReasonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 退货原因表(OmsOrderReturnReason)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@RestController
@RequestMapping("omsOrderReturnReason")
public class OmsOrderReturnReasonController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderReturnReasonService omsOrderReturnReasonService;

}
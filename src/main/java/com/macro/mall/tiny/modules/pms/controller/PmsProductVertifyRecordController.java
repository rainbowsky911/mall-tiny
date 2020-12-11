package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductVertifyRecord;
import com.macro.mall.tiny.modules.pms.service.PmsProductVertifyRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品审核记录(PmsProductVertifyRecord)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:35
 */
@RestController
@RequestMapping("pmsProductVertifyRecord")
public class PmsProductVertifyRecordController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;


}
package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductLadder;
import com.macro.mall.tiny.modules.pms.service.PmsProductLadderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品阶梯价格表(只针对同商品)(PmsProductLadder)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@RestController
@RequestMapping("pmsProductLadder")
public class PmsProductLadderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductLadderService pmsProductLadderService;

}
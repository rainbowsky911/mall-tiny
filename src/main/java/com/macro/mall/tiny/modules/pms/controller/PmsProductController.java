package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品信息(PmsProduct)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
@RestController
@RequestMapping("pmsProduct")
public class PmsProductController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductService pmsProductService;


}
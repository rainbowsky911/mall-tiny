package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategoryAttributeRelation;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryAttributeRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）(PmsProductCategoryAttributeRelation)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
@RestController
@RequestMapping("pmsProductCategoryAttributeRelation")
public class PmsProductCategoryAttributeRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;


}
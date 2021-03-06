package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceAreaProductRelation;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaProductRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 优选专区和产品关系表(CmsPrefrenceAreaProductRelation)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:15
 */
@RestController
@RequestMapping("cmsPrefrenceAreaProductRelation")
public class CmsPrefrenceAreaProductRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsPrefrenceAreaProductRelationService cmsPrefrenceAreaProductRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                            分页对象
     * @param cmsPrefrenceAreaProductRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CmsPrefrenceAreaProductRelation> page, CmsPrefrenceAreaProductRelation cmsPrefrenceAreaProductRelation) {
        return success(this.cmsPrefrenceAreaProductRelationService.page(page, new QueryWrapper<>(cmsPrefrenceAreaProductRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cmsPrefrenceAreaProductRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsPrefrenceAreaProductRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CmsPrefrenceAreaProductRelation cmsPrefrenceAreaProductRelation) {
        return success(this.cmsPrefrenceAreaProductRelationService.save(cmsPrefrenceAreaProductRelation));
    }

    /**
     * 修改数据
     *
     * @param cmsPrefrenceAreaProductRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CmsPrefrenceAreaProductRelation cmsPrefrenceAreaProductRelation) {
        return success(this.cmsPrefrenceAreaProductRelationService.updateById(cmsPrefrenceAreaProductRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cmsPrefrenceAreaProductRelationService.removeByIds(idList));
    }
}
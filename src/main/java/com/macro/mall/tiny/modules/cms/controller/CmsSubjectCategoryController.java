package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectCategory;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 专题分类表(CmsSubjectCategory)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:16
 */
@RestController
@RequestMapping("cmsSubjectCategory")
public class CmsSubjectCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsSubjectCategoryService cmsSubjectCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page               分页对象
     * @param cmsSubjectCategory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CmsSubjectCategory> page, CmsSubjectCategory cmsSubjectCategory) {
        return success(this.cmsSubjectCategoryService.page(page, new QueryWrapper<>(cmsSubjectCategory)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cmsSubjectCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsSubjectCategory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CmsSubjectCategory cmsSubjectCategory) {
        return success(this.cmsSubjectCategoryService.save(cmsSubjectCategory));
    }

    /**
     * 修改数据
     *
     * @param cmsSubjectCategory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CmsSubjectCategory cmsSubjectCategory) {
        return success(this.cmsSubjectCategoryService.updateById(cmsSubjectCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cmsSubjectCategoryService.removeByIds(idList));
    }
}
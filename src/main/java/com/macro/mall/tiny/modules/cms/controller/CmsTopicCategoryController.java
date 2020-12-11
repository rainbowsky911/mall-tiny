package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cms.entity.CmsTopicCategory;
import com.macro.mall.tiny.modules.cms.service.CmsTopicCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 话题分类表(CmsTopicCategory)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:18
 */
@RestController
@RequestMapping("cmsTopicCategory")
public class CmsTopicCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsTopicCategoryService cmsTopicCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param cmsTopicCategory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CmsTopicCategory> page, CmsTopicCategory cmsTopicCategory) {
        return success(this.cmsTopicCategoryService.page(page, new QueryWrapper<>(cmsTopicCategory)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cmsTopicCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsTopicCategory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CmsTopicCategory cmsTopicCategory) {
        return success(this.cmsTopicCategoryService.save(cmsTopicCategory));
    }

    /**
     * 修改数据
     *
     * @param cmsTopicCategory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CmsTopicCategory cmsTopicCategory) {
        return success(this.cmsTopicCategoryService.updateById(cmsTopicCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cmsTopicCategoryService.removeByIds(idList));
    }
}
package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberProductCategoryRelation;
import com.macro.mall.tiny.modules.ums.service.UmsMemberProductCategoryRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 会员与产品分类关系表（用户喜欢的分类）(UmsMemberProductCategoryRelation)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:22
 */
@RestController
@RequestMapping("umsMemberProductCategoryRelation")
public class UmsMemberProductCategoryRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberProductCategoryRelationService umsMemberProductCategoryRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                             分页对象
     * @param umsMemberProductCategoryRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsMemberProductCategoryRelation> page, UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        return success(this.umsMemberProductCategoryRelationService.page(page, new QueryWrapper<>(umsMemberProductCategoryRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsMemberProductCategoryRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberProductCategoryRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        return success(this.umsMemberProductCategoryRelationService.save(umsMemberProductCategoryRelation));
    }

    /**
     * 修改数据
     *
     * @param umsMemberProductCategoryRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        return success(this.umsMemberProductCategoryRelationService.updateById(umsMemberProductCategoryRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsMemberProductCategoryRelationService.removeByIds(idList));
    }
}
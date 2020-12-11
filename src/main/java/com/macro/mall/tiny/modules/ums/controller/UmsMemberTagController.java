package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberTag;
import com.macro.mall.tiny.modules.ums.service.UmsMemberTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户标签表(UmsMemberTag)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:25
 */
@RestController
@RequestMapping("umsMemberTag")
public class UmsMemberTagController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberTagService umsMemberTagService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param umsMemberTag 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsMemberTag> page, UmsMemberTag umsMemberTag) {
        return success(this.umsMemberTagService.page(page, new QueryWrapper<>(umsMemberTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsMemberTagService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsMemberTag umsMemberTag) {
        return success(this.umsMemberTagService.save(umsMemberTag));
    }

    /**
     * 修改数据
     *
     * @param umsMemberTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsMemberTag umsMemberTag) {
        return success(this.umsMemberTagService.updateById(umsMemberTag));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsMemberTagService.removeByIds(idList));
    }
}
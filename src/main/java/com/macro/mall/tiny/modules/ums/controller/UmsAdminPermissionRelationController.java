package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.ums.entity.UmsAdminPermissionRelation;
import com.macro.mall.tiny.modules.ums.service.UmsAdminPermissionRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:17
 */
@RestController
@RequestMapping("umsAdminPermissionRelation")
public class UmsAdminPermissionRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                       分页对象
     * @param umsAdminPermissionRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsAdminPermissionRelation> page, UmsAdminPermissionRelation umsAdminPermissionRelation) {
        return success(this.umsAdminPermissionRelationService.page(page, new QueryWrapper<>(umsAdminPermissionRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsAdminPermissionRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        return success(this.umsAdminPermissionRelationService.save(umsAdminPermissionRelation));
    }

    /**
     * 修改数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        return success(this.umsAdminPermissionRelationService.updateById(umsAdminPermissionRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsAdminPermissionRelationService.removeByIds(idList));
    }
}
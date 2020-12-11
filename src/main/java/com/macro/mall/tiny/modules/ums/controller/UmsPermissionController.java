package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.ums.entity.UmsPermission;
import com.macro.mall.tiny.modules.ums.service.UmsPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 后台用户权限表(UmsPermission)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:26
 */
@RestController
@RequestMapping("umsPermission")
public class UmsPermissionController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsPermissionService umsPermissionService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param umsPermission 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsPermission> page, UmsPermission umsPermission) {
        return success(this.umsPermissionService.page(page, new QueryWrapper<>(umsPermission)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsPermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsPermission 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsPermission umsPermission) {
        return success(this.umsPermissionService.save(umsPermission));
    }

    /**
     * 修改数据
     *
     * @param umsPermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsPermission umsPermission) {
        return success(this.umsPermissionService.updateById(umsPermission));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsPermissionService.removeByIds(idList));
    }
}
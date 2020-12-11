package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsAlbum;
import com.macro.mall.tiny.modules.pms.service.PmsAlbumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 相册表(PmsAlbum)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:27
 */
@RestController
@RequestMapping("pmsAlbum")
public class PmsAlbumController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsAlbumService pmsAlbumService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param pmsAlbum 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsAlbum> page, PmsAlbum pmsAlbum) {
        return success(this.pmsAlbumService.page(page, new QueryWrapper<>(pmsAlbum)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsAlbumService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsAlbum 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsAlbum pmsAlbum) {
        return success(this.pmsAlbumService.save(pmsAlbum));
    }

    /**
     * 修改数据
     *
     * @param pmsAlbum 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsAlbum pmsAlbum) {
        return success(this.pmsAlbumService.updateById(pmsAlbum));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsAlbumService.removeByIds(idList));
    }
}
package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceArea;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 优选专区(CmsPrefrenceArea)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@RestController
@RequestMapping("cmsPrefrenceArea")
public class CmsPrefrenceAreaController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param cmsPrefrenceArea 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CmsPrefrenceArea> page, CmsPrefrenceArea cmsPrefrenceArea) {
        return success(this.cmsPrefrenceAreaService.page(page, new QueryWrapper<>(cmsPrefrenceArea)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cmsPrefrenceAreaService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsPrefrenceArea 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CmsPrefrenceArea cmsPrefrenceArea) {
        return success(this.cmsPrefrenceAreaService.save(cmsPrefrenceArea));
    }

    /**
     * 修改数据
     *
     * @param cmsPrefrenceArea 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CmsPrefrenceArea cmsPrefrenceArea) {
        return success(this.cmsPrefrenceAreaService.updateById(cmsPrefrenceArea));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cmsPrefrenceAreaService.removeByIds(idList));
    }
}
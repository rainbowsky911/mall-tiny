package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.service.PmsBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 品牌表(PmsBrand)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@RestController
@RequestMapping("pmsBrand")
public class PmsBrandController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsBrandService pmsBrandService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param pmsBrand 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsBrand> page, PmsBrand pmsBrand) {
        return success(this.pmsBrandService.page(page, new QueryWrapper<>(pmsBrand)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsBrandService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsBrand 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsBrand pmsBrand) {
        return success(this.pmsBrandService.save(pmsBrand));
    }

    /**
     * 修改数据
     *
     * @param pmsBrand 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsBrand pmsBrand) {
        return success(this.pmsBrandService.updateById(pmsBrand));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsBrandService.removeByIds(idList));
    }
}
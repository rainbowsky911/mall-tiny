package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品信息(PmsProduct)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
@RestController
@RequestMapping("pmsProduct")
public class PmsProductController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductService pmsProductService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param pmsProduct 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsProduct> page, PmsProduct pmsProduct) {
        return success(this.pmsProductService.page(page, new QueryWrapper<>(pmsProduct)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsProductService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsProduct 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsProduct pmsProduct) {
        return success(this.pmsProductService.save(pmsProduct));
    }

    /**
     * 修改数据
     *
     * @param pmsProduct 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsProduct pmsProduct) {
        return success(this.pmsProductService.updateById(pmsProduct));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsProductService.removeByIds(idList));
    }
}
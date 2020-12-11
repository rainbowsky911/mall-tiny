package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import com.macro.mall.tiny.modules.pms.service.PmsSkuStockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * sku的库存(PmsSkuStock)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:43:00
 */
@RestController
@RequestMapping("pmsSkuStock")
public class PmsSkuStockController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuStockService pmsSkuStockService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param pmsSkuStock 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsSkuStock> page, PmsSkuStock pmsSkuStock) {
        return success(this.pmsSkuStockService.page(page, new QueryWrapper<>(pmsSkuStock)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsSkuStockService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsSkuStock 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsSkuStock pmsSkuStock) {
        return success(this.pmsSkuStockService.save(pmsSkuStock));
    }

    /**
     * 修改数据
     *
     * @param pmsSkuStock 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsSkuStock pmsSkuStock) {
        return success(this.pmsSkuStockService.updateById(pmsSkuStock));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsSkuStockService.removeByIds(idList));
    }
}
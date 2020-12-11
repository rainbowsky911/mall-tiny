package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductLadder;
import com.macro.mall.tiny.modules.pms.service.PmsProductLadderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品阶梯价格表(只针对同商品)(PmsProductLadder)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@RestController
@RequestMapping("pmsProductLadder")
public class PmsProductLadderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductLadderService pmsProductLadderService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param pmsProductLadder 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsProductLadder> page, PmsProductLadder pmsProductLadder) {
        return success(this.pmsProductLadderService.page(page, new QueryWrapper<>(pmsProductLadder)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsProductLadderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsProductLadder 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsProductLadder pmsProductLadder) {
        return success(this.pmsProductLadderService.save(pmsProductLadder));
    }

    /**
     * 修改数据
     *
     * @param pmsProductLadder 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsProductLadder pmsProductLadder) {
        return success(this.pmsProductLadderService.updateById(pmsProductLadder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsProductLadderService.removeByIds(idList));
    }
}
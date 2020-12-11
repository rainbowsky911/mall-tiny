package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductVertifyRecord;
import com.macro.mall.tiny.modules.pms.service.PmsProductVertifyRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品审核记录(PmsProductVertifyRecord)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:35
 */
@RestController
@RequestMapping("pmsProductVertifyRecord")
public class PmsProductVertifyRecordController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;

    /**
     * 分页查询所有数据
     *
     * @param page                    分页对象
     * @param pmsProductVertifyRecord 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsProductVertifyRecord> page, PmsProductVertifyRecord pmsProductVertifyRecord) {
        return success(this.pmsProductVertifyRecordService.page(page, new QueryWrapper<>(pmsProductVertifyRecord)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsProductVertifyRecordService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsProductVertifyRecord 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsProductVertifyRecord pmsProductVertifyRecord) {
        return success(this.pmsProductVertifyRecordService.save(pmsProductVertifyRecord));
    }

    /**
     * 修改数据
     *
     * @param pmsProductVertifyRecord 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsProductVertifyRecord pmsProductVertifyRecord) {
        return success(this.pmsProductVertifyRecordService.updateById(pmsProductVertifyRecord));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsProductVertifyRecordService.removeByIds(idList));
    }
}
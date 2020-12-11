package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsProductOperateLog;
import com.macro.mall.tiny.modules.pms.service.PmsProductOperateLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (PmsProductOperateLog)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:35
 */
@RestController
@RequestMapping("pmsProductOperateLog")
public class PmsProductOperateLogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductOperateLogService pmsProductOperateLogService;

    /**
     * 分页查询所有数据
     *
     * @param page                 分页对象
     * @param pmsProductOperateLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsProductOperateLog> page, PmsProductOperateLog pmsProductOperateLog) {
        return success(this.pmsProductOperateLogService.page(page, new QueryWrapper<>(pmsProductOperateLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsProductOperateLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsProductOperateLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsProductOperateLog pmsProductOperateLog) {
        return success(this.pmsProductOperateLogService.save(pmsProductOperateLog));
    }

    /**
     * 修改数据
     *
     * @param pmsProductOperateLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsProductOperateLog pmsProductOperateLog) {
        return success(this.pmsProductOperateLogService.updateById(pmsProductOperateLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsProductOperateLogService.removeByIds(idList));
    }
}
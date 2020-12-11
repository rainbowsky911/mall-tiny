package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cms.entity.CmsMemberReport;
import com.macro.mall.tiny.modules.cms.service.CmsMemberReportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户举报表(CmsMemberReport)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@RestController
@RequestMapping("cmsMemberReport")
public class CmsMemberReportController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsMemberReportService cmsMemberReportService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param cmsMemberReport 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CmsMemberReport> page, CmsMemberReport cmsMemberReport) {
        return success(this.cmsMemberReportService.page(page, new QueryWrapper<>(cmsMemberReport)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cmsMemberReportService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsMemberReport 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CmsMemberReport cmsMemberReport) {
        return success(this.cmsMemberReportService.save(cmsMemberReport));
    }

    /**
     * 修改数据
     *
     * @param cmsMemberReport 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CmsMemberReport cmsMemberReport) {
        return success(this.cmsMemberReportService.updateById(cmsMemberReport));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cmsMemberReportService.removeByIds(idList));
    }
}
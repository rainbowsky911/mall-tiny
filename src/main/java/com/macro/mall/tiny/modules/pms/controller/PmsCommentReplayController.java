package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsCommentReplay;
import com.macro.mall.tiny.modules.pms.service.PmsCommentReplayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品评价回复表(PmsCommentReplay)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:29
 */
@RestController
@RequestMapping("pmsCommentReplay")
public class PmsCommentReplayController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsCommentReplayService pmsCommentReplayService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param pmsCommentReplay 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PmsCommentReplay> page, PmsCommentReplay pmsCommentReplay) {
        return success(this.pmsCommentReplayService.page(page, new QueryWrapper<>(pmsCommentReplay)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pmsCommentReplayService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsCommentReplay 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PmsCommentReplay pmsCommentReplay) {
        return success(this.pmsCommentReplayService.save(pmsCommentReplay));
    }

    /**
     * 修改数据
     *
     * @param pmsCommentReplay 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PmsCommentReplay pmsCommentReplay) {
        return success(this.pmsCommentReplayService.updateById(pmsCommentReplay));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsCommentReplayService.removeByIds(idList));
    }
}
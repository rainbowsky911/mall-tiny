package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单退货申请(OmsOrderReturnApply)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@RestController
@RequestMapping("omsOrderReturnApply")
public class OmsOrderReturnApplyController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderReturnApplyService omsOrderReturnApplyService;

    /**
     * 分页查询所有数据
     *
     * @param page                分页对象
     * @param omsOrderReturnApply 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<OmsOrderReturnApply> page, OmsOrderReturnApply omsOrderReturnApply) {
        return success(this.omsOrderReturnApplyService.page(page, new QueryWrapper<>(omsOrderReturnApply)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.omsOrderReturnApplyService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param omsOrderReturnApply 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody OmsOrderReturnApply omsOrderReturnApply) {
        return success(this.omsOrderReturnApplyService.save(omsOrderReturnApply));
    }

    /**
     * 修改数据
     *
     * @param omsOrderReturnApply 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody OmsOrderReturnApply omsOrderReturnApply) {
        return success(this.omsOrderReturnApplyService.updateById(omsOrderReturnApply));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.omsOrderReturnApplyService.removeByIds(idList));
    }
}
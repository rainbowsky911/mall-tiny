package com.macro.mall.tiny.modules.sms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponProductRelation;
import com.macro.mall.tiny.modules.sms.service.SmsCouponProductRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 优惠券和产品的关系表(SmsCouponProductRelation)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:43:58
 */
@RestController
@RequestMapping("smsCouponProductRelation")
public class SmsCouponProductRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SmsCouponProductRelationService smsCouponProductRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                     分页对象
     * @param smsCouponProductRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SmsCouponProductRelation> page, SmsCouponProductRelation smsCouponProductRelation) {
        return success(this.smsCouponProductRelationService.page(page, new QueryWrapper<>(smsCouponProductRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.smsCouponProductRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param smsCouponProductRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SmsCouponProductRelation smsCouponProductRelation) {
        return success(this.smsCouponProductRelationService.save(smsCouponProductRelation));
    }

    /**
     * 修改数据
     *
     * @param smsCouponProductRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SmsCouponProductRelation smsCouponProductRelation) {
        return success(this.smsCouponProductRelationService.updateById(smsCouponProductRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.smsCouponProductRelationService.removeByIds(idList));
    }
}
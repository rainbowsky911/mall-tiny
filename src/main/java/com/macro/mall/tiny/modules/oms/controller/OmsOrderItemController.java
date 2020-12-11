package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;
import com.macro.mall.tiny.modules.oms.service.OmsOrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单中所包含的商品(OmsOrderItem)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@RestController
@RequestMapping("omsOrderItem")
public class OmsOrderItemController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderItemService omsOrderItemService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param omsOrderItem 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<OmsOrderItem> page, OmsOrderItem omsOrderItem) {
        return success(this.omsOrderItemService.page(page, new QueryWrapper<>(omsOrderItem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.omsOrderItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param omsOrderItem 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody OmsOrderItem omsOrderItem) {
        return success(this.omsOrderItemService.save(omsOrderItem));
    }

    /**
     * 修改数据
     *
     * @param omsOrderItem 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody OmsOrderItem omsOrderItem) {
        return success(this.omsOrderItemService.updateById(omsOrderItem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.omsOrderItemService.removeByIds(idList));
    }
}
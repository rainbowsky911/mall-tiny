package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 购物车表(OmsCartItem)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:50
 */
@RestController
@RequestMapping("omsCartItem")
public class OmsCartItemController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsCartItemService omsCartItemService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param omsCartItem 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<OmsCartItem> page, OmsCartItem omsCartItem) {
        return success(this.omsCartItemService.page(page, new QueryWrapper<>(omsCartItem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.omsCartItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param omsCartItem 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody OmsCartItem omsCartItem) {
        return success(this.omsCartItemService.save(omsCartItem));
    }

    /**
     * 修改数据
     *
     * @param omsCartItem 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody OmsCartItem omsCartItem) {
        return success(this.omsCartItemService.updateById(omsCartItem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.omsCartItemService.removeByIds(idList));
    }
}
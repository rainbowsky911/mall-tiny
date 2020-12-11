package com.macro.mall.tiny.modules.sms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeNewProduct;
import com.macro.mall.tiny.modules.sms.service.SmsHomeNewProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 新鲜好物表(SmsHomeNewProduct)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:44:03
 */
@RestController
@RequestMapping("smsHomeNewProduct")
public class SmsHomeNewProductController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SmsHomeNewProductService smsHomeNewProductService;

    /**
     * 分页查询所有数据
     *
     * @param page              分页对象
     * @param smsHomeNewProduct 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SmsHomeNewProduct> page, SmsHomeNewProduct smsHomeNewProduct) {
        return success(this.smsHomeNewProductService.page(page, new QueryWrapper<>(smsHomeNewProduct)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.smsHomeNewProductService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param smsHomeNewProduct 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SmsHomeNewProduct smsHomeNewProduct) {
        return success(this.smsHomeNewProductService.save(smsHomeNewProduct));
    }

    /**
     * 修改数据
     *
     * @param smsHomeNewProduct 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SmsHomeNewProduct smsHomeNewProduct) {
        return success(this.smsHomeNewProductService.updateById(smsHomeNewProduct));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.smsHomeNewProductService.removeByIds(idList));
    }
}
package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.entity.OmsCompanyAddress;
import com.macro.mall.tiny.modules.oms.service.OmsCompanyAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 公司收发货地址表(OmsCompanyAddress)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:51
 */
@RestController
@RequestMapping("omsCompanyAddress")
public class OmsCompanyAddressController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsCompanyAddressService omsCompanyAddressService;

    /**
     * 分页查询所有数据
     *
     * @param page              分页对象
     * @param omsCompanyAddress 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<OmsCompanyAddress> page, OmsCompanyAddress omsCompanyAddress) {
        return success(this.omsCompanyAddressService.page(page, new QueryWrapper<>(omsCompanyAddress)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.omsCompanyAddressService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param omsCompanyAddress 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody OmsCompanyAddress omsCompanyAddress) {
        return success(this.omsCompanyAddressService.save(omsCompanyAddress));
    }

    /**
     * 修改数据
     *
     * @param omsCompanyAddress 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody OmsCompanyAddress omsCompanyAddress) {
        return success(this.omsCompanyAddressService.updateById(omsCompanyAddress));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.omsCompanyAddressService.removeByIds(idList));
    }
}
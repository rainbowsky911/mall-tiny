package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.ums.entity.UmsIntegrationConsumeSetting;
import com.macro.mall.tiny.modules.ums.service.UmsIntegrationConsumeSettingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 积分消费设置(UmsIntegrationConsumeSetting)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:18
 */
@RestController
@RequestMapping("umsIntegrationConsumeSetting")
public class UmsIntegrationConsumeSettingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsIntegrationConsumeSettingService umsIntegrationConsumeSettingService;

    /**
     * 分页查询所有数据
     *
     * @param page                         分页对象
     * @param umsIntegrationConsumeSetting 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsIntegrationConsumeSetting> page, UmsIntegrationConsumeSetting umsIntegrationConsumeSetting) {
        return success(this.umsIntegrationConsumeSettingService.page(page, new QueryWrapper<>(umsIntegrationConsumeSetting)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsIntegrationConsumeSettingService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsIntegrationConsumeSetting 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsIntegrationConsumeSetting umsIntegrationConsumeSetting) {
        return success(this.umsIntegrationConsumeSettingService.save(umsIntegrationConsumeSetting));
    }

    /**
     * 修改数据
     *
     * @param umsIntegrationConsumeSetting 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsIntegrationConsumeSetting umsIntegrationConsumeSetting) {
        return success(this.umsIntegrationConsumeSettingService.updateById(umsIntegrationConsumeSetting));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsIntegrationConsumeSettingService.removeByIds(idList));
    }
}
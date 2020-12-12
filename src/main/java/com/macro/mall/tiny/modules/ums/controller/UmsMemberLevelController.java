package com.macro.mall.tiny.modules.ums.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLevel;
import com.macro.mall.tiny.modules.ums.service.UmsMemberLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 会员等级表(UmsMemberLevel)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:46:20
 */
@RestController
@RequestMapping("memberLevel")
public class UmsMemberLevelController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberLevelService umsMemberLevelService;


    @GetMapping("/list")
    public CommonResult<List<UmsMemberLevel>> getMemberLevelList(@RequestParam("defaultStatus") Long defaultStatus) {
        return CommonResult.success(umsMemberLevelService.getMemberLevelList(defaultStatus));
    }

}
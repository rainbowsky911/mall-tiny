package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cms.entity.CmsSubject;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectService;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLevel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 专题表(CmsSubject)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:15
 */
@RestController
@RequestMapping("subject")
public class CmsSubjectController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsSubjectService cmsSubjectService;


    /**
     * 查询所有专题
     *
     * @return
     */
    @GetMapping("/listAll")
    public CommonResult<List<CmsSubject>> getCmsSubjectList() {
        return CommonResult.success(cmsSubjectService.getCmsSubjectList());
    }

}
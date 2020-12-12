package com.macro.mall.tiny.modules.cms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceArea;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优选专区(CmsPrefrenceArea)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@RestController
@RequestMapping("prefrenceArea")
public class CmsPrefrenceAreaController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    /**
     * 查询所有优选
     * @return
     */
    @GetMapping("/listAll")
    public CommonResult<List<CmsPrefrenceArea>> getCmsPrefrenceAreaList() {
        return CommonResult.success(cmsPrefrenceAreaService.getCmsPrefrenceAreaList());
    }
}
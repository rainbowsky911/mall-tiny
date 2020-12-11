package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.entity.PmsAlbumPic;
import com.macro.mall.tiny.modules.pms.service.PmsAlbumPicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 画册图片表(PmsAlbumPic)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@RestController
@RequestMapping("pmsAlbumPic")
public class PmsAlbumPicController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PmsAlbumPicService pmsAlbumPicService;


}
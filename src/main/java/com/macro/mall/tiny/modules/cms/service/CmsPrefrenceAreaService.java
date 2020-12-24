package com.macro.mall.tiny.modules.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceArea;

import java.util.List;

/**
 * 优选专区(CmsPrefrenceArea)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
public interface CmsPrefrenceAreaService extends IService<CmsPrefrenceArea> {

    /**
     * 查询所有优选
     *
     * @return
     */
    List<CmsPrefrenceArea> getCmsPrefrenceAreaList();
}
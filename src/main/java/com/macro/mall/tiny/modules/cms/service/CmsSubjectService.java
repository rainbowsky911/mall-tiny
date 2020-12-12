package com.macro.mall.tiny.modules.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.cms.entity.CmsSubject;

import java.util.List;

/**
 * 专题表(CmsSubject)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:20:15
 */
public interface CmsSubjectService extends IService<CmsSubject> {

    /**
     * 查询所有专题
     * @return
     */
    List<CmsSubject> getCmsSubjectList();
}
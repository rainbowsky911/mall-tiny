package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsSubjectDao;
import com.macro.mall.tiny.modules.cms.entity.CmsSubject;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectService;
import org.springframework.stereotype.Service;

/**
 * 专题表(CmsSubject)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:15
 */
@Service("cmsSubjectService")
public class CmsSubjectServiceImpl extends ServiceImpl<CmsSubjectDao, CmsSubject> implements CmsSubjectService {

}
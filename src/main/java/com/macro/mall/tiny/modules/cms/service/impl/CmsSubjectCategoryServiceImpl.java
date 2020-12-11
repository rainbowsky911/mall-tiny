package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsSubjectCategoryDao;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectCategory;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectCategoryService;
import org.springframework.stereotype.Service;

/**
 * 专题分类表(CmsSubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:16
 */
@Service("cmsSubjectCategoryService")
public class CmsSubjectCategoryServiceImpl extends ServiceImpl<CmsSubjectCategoryDao, CmsSubjectCategory> implements CmsSubjectCategoryService {

}
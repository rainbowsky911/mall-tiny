package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsHelpCategoryDao;
import com.macro.mall.tiny.modules.cms.entity.CmsHelpCategory;
import com.macro.mall.tiny.modules.cms.service.CmsHelpCategoryService;
import org.springframework.stereotype.Service;

/**
 * 帮助分类表(CmsHelpCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:13
 */
@Service("cmsHelpCategoryService")
public class CmsHelpCategoryServiceImpl extends ServiceImpl<CmsHelpCategoryDao, CmsHelpCategory> implements CmsHelpCategoryService {

}
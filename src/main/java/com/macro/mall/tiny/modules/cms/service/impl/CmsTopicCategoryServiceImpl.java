package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsTopicCategoryDao;
import com.macro.mall.tiny.modules.cms.entity.CmsTopicCategory;
import com.macro.mall.tiny.modules.cms.service.CmsTopicCategoryService;
import org.springframework.stereotype.Service;

/**
 * 话题分类表(CmsTopicCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:18
 */
@Service("cmsTopicCategoryService")
public class CmsTopicCategoryServiceImpl extends ServiceImpl<CmsTopicCategoryDao, CmsTopicCategory> implements CmsTopicCategoryService {

}
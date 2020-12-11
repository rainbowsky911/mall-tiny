package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsSubjectProductRelationDao;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectProductRelation;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectProductRelationService;
import org.springframework.stereotype.Service;

/**
 * 专题商品关系表(CmsSubjectProductRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:17
 */
@Service("cmsSubjectProductRelationService")
public class CmsSubjectProductRelationServiceImpl extends ServiceImpl<CmsSubjectProductRelationDao, CmsSubjectProductRelation> implements CmsSubjectProductRelationService {

}
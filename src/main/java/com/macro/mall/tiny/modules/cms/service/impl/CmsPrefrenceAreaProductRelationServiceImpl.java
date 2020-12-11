package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsPrefrenceAreaProductRelationDao;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceAreaProductRelation;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaProductRelationService;
import org.springframework.stereotype.Service;

/**
 * 优选专区和产品关系表(CmsPrefrenceAreaProductRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:15
 */
@Service("cmsPrefrenceAreaProductRelationService")
public class CmsPrefrenceAreaProductRelationServiceImpl extends ServiceImpl<CmsPrefrenceAreaProductRelationDao, CmsPrefrenceAreaProductRelation> implements CmsPrefrenceAreaProductRelationService {

}
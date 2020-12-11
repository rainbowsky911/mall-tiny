package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberProductCategoryRelationDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberProductCategoryRelation;
import com.macro.mall.tiny.modules.ums.service.UmsMemberProductCategoryRelationService;
import org.springframework.stereotype.Service;

/**
 * 会员与产品分类关系表（用户喜欢的分类）(UmsMemberProductCategoryRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:22
 */
@Service("umsMemberProductCategoryRelationService")
public class UmsMemberProductCategoryRelationServiceImpl extends ServiceImpl<UmsMemberProductCategoryRelationDao, UmsMemberProductCategoryRelation> implements UmsMemberProductCategoryRelationService {

}
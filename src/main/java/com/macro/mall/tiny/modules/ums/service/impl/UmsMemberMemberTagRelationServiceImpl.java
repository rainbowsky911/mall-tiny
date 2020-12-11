package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberMemberTagRelationDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberMemberTagRelation;
import com.macro.mall.tiny.modules.ums.service.UmsMemberMemberTagRelationService;
import org.springframework.stereotype.Service;

/**
 * 用户和标签关系表(UmsMemberMemberTagRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:21
 */
@Service("umsMemberMemberTagRelationService")
public class UmsMemberMemberTagRelationServiceImpl extends ServiceImpl<UmsMemberMemberTagRelationDao, UmsMemberMemberTagRelation> implements UmsMemberMemberTagRelationService {

}
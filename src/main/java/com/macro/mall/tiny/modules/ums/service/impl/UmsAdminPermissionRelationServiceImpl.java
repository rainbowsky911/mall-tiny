package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsAdminPermissionRelationDao;
import com.macro.mall.tiny.modules.ums.entity.UmsAdminPermissionRelation;
import com.macro.mall.tiny.modules.ums.service.UmsAdminPermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:17
 */
@Service("umsAdminPermissionRelationService")
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationDao, UmsAdminPermissionRelation> implements UmsAdminPermissionRelationService {

}
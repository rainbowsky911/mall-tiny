package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsRolePermissionRelationDao;
import com.macro.mall.tiny.modules.ums.entity.UmsRolePermissionRelation;
import com.macro.mall.tiny.modules.ums.service.UmsRolePermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:26
 */
@Service("umsRolePermissionRelationService")
public class UmsRolePermissionRelationServiceImpl extends ServiceImpl<UmsRolePermissionRelationDao, UmsRolePermissionRelation> implements UmsRolePermissionRelationService {

}
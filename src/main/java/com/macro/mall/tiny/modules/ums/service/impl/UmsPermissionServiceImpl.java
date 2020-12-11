package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsPermissionDao;
import com.macro.mall.tiny.modules.ums.entity.UmsPermission;
import com.macro.mall.tiny.modules.ums.service.UmsPermissionService;
import org.springframework.stereotype.Service;

/**
 * 后台用户权限表(UmsPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:26
 */
@Service("umsPermissionService")
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionDao, UmsPermission> implements UmsPermissionService {

}
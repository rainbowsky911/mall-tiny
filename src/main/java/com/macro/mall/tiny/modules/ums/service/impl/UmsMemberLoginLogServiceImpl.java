package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberLoginLogDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLoginLog;
import com.macro.mall.tiny.modules.ums.service.UmsMemberLoginLogService;
import org.springframework.stereotype.Service;

/**
 * 会员登录记录(UmsMemberLoginLog)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:20
 */
@Service("umsMemberLoginLogService")
public class UmsMemberLoginLogServiceImpl extends ServiceImpl<UmsMemberLoginLogDao, UmsMemberLoginLog> implements UmsMemberLoginLogService {

}
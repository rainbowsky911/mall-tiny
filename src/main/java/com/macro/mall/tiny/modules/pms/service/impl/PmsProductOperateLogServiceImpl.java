package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductOperateLogDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductOperateLog;
import com.macro.mall.tiny.modules.pms.service.PmsProductOperateLogService;
import org.springframework.stereotype.Service;

/**
 * (PmsProductOperateLog)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:35
 */
@Service("pmsProductOperateLogService")
public class PmsProductOperateLogServiceImpl extends ServiceImpl<PmsProductOperateLogDao, PmsProductOperateLog> implements PmsProductOperateLogService {

}
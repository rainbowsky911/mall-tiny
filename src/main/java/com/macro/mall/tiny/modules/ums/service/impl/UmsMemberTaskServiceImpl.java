package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberTaskDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberTask;
import com.macro.mall.tiny.modules.ums.service.UmsMemberTaskService;
import org.springframework.stereotype.Service;

/**
 * 会员任务表(UmsMemberTask)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:25
 */
@Service("umsMemberTaskService")
public class UmsMemberTaskServiceImpl extends ServiceImpl<UmsMemberTaskDao, UmsMemberTask> implements UmsMemberTaskService {

}
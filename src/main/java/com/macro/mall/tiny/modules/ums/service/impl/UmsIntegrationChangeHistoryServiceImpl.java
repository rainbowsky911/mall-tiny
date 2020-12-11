package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsIntegrationChangeHistoryDao;
import com.macro.mall.tiny.modules.ums.entity.UmsIntegrationChangeHistory;
import com.macro.mall.tiny.modules.ums.service.UmsIntegrationChangeHistoryService;
import org.springframework.stereotype.Service;

/**
 * 积分变化历史记录表(UmsIntegrationChangeHistory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:18
 */
@Service("umsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl extends ServiceImpl<UmsIntegrationChangeHistoryDao, UmsIntegrationChangeHistory> implements UmsIntegrationChangeHistoryService {

}
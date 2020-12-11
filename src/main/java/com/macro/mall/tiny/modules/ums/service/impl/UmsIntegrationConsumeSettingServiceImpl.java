package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsIntegrationConsumeSettingDao;
import com.macro.mall.tiny.modules.ums.entity.UmsIntegrationConsumeSetting;
import com.macro.mall.tiny.modules.ums.service.UmsIntegrationConsumeSettingService;
import org.springframework.stereotype.Service;

/**
 * 积分消费设置(UmsIntegrationConsumeSetting)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:18
 */
@Service("umsIntegrationConsumeSettingService")
public class UmsIntegrationConsumeSettingServiceImpl extends ServiceImpl<UmsIntegrationConsumeSettingDao, UmsIntegrationConsumeSetting> implements UmsIntegrationConsumeSettingService {

}
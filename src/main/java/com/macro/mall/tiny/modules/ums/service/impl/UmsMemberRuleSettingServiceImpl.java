package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberRuleSettingDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberRuleSetting;
import com.macro.mall.tiny.modules.ums.service.UmsMemberRuleSettingService;
import org.springframework.stereotype.Service;

/**
 * 会员积分成长规则表(UmsMemberRuleSetting)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:23
 */
@Service("umsMemberRuleSettingService")
public class UmsMemberRuleSettingServiceImpl extends ServiceImpl<UmsMemberRuleSettingDao, UmsMemberRuleSetting> implements UmsMemberRuleSettingService {

}
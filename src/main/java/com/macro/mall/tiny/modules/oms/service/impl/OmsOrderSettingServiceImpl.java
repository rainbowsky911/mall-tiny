package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderSettingDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderSetting;
import com.macro.mall.tiny.modules.oms.service.OmsOrderSettingService;
import org.springframework.stereotype.Service;

/**
 * 订单设置表(OmsOrderSetting)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:55
 */
@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingDao, OmsOrderSetting> implements OmsOrderSettingService {

}
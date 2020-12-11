package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsHomeAdvertiseDao;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeAdvertise;
import com.macro.mall.tiny.modules.sms.service.SmsHomeAdvertiseService;
import org.springframework.stereotype.Service;

/**
 * 首页轮播广告表(SmsHomeAdvertise)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:01
 */
@Service("smsHomeAdvertiseService")
public class SmsHomeAdvertiseServiceImpl extends ServiceImpl<SmsHomeAdvertiseDao, SmsHomeAdvertise> implements SmsHomeAdvertiseService {

}
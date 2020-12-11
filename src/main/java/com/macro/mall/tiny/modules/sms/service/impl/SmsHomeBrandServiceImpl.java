package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsHomeBrandDao;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeBrand;
import com.macro.mall.tiny.modules.sms.service.SmsHomeBrandService;
import org.springframework.stereotype.Service;

/**
 * 首页推荐品牌表(SmsHomeBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:02
 */
@Service("smsHomeBrandService")
public class SmsHomeBrandServiceImpl extends ServiceImpl<SmsHomeBrandDao, SmsHomeBrand> implements SmsHomeBrandService {

}
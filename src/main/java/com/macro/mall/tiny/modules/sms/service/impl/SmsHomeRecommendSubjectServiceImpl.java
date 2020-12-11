package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsHomeRecommendSubjectDao;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeRecommendSubject;
import com.macro.mall.tiny.modules.sms.service.SmsHomeRecommendSubjectService;
import org.springframework.stereotype.Service;

/**
 * 首页推荐专题表(SmsHomeRecommendSubject)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:04
 */
@Service("smsHomeRecommendSubjectService")
public class SmsHomeRecommendSubjectServiceImpl extends ServiceImpl<SmsHomeRecommendSubjectDao, SmsHomeRecommendSubject> implements SmsHomeRecommendSubjectService {

}
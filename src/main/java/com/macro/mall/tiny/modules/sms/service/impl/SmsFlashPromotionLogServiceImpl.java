package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsFlashPromotionLogDao;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotionLog;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionLogService;
import org.springframework.stereotype.Service;

/**
 * 限时购通知记录(SmsFlashPromotionLog)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:59
 */
@Service("smsFlashPromotionLogService")
public class SmsFlashPromotionLogServiceImpl extends ServiceImpl<SmsFlashPromotionLogDao, SmsFlashPromotionLog> implements SmsFlashPromotionLogService {

}
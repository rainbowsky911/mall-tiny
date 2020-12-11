package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsFlashPromotionSessionDao;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotionSession;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionSessionService;
import org.springframework.stereotype.Service;

/**
 * 限时购场次表(SmsFlashPromotionSession)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:01
 */
@Service("smsFlashPromotionSessionService")
public class SmsFlashPromotionSessionServiceImpl extends ServiceImpl<SmsFlashPromotionSessionDao, SmsFlashPromotionSession> implements SmsFlashPromotionSessionService {

}
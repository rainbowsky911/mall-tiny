package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsFlashPromotionDao;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotion;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionService;
import org.springframework.stereotype.Service;

/**
 * 限时购表(SmsFlashPromotion)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:59
 */
@Service("smsFlashPromotionService")
public class SmsFlashPromotionServiceImpl extends ServiceImpl<SmsFlashPromotionDao, SmsFlashPromotion> implements SmsFlashPromotionService {

}
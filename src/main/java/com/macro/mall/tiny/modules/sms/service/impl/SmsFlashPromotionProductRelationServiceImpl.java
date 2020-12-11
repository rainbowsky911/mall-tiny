package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsFlashPromotionProductRelationDao;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotionProductRelation;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionProductRelationService;
import org.springframework.stereotype.Service;

/**
 * 商品限时购与商品关系表(SmsFlashPromotionProductRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:00
 */
@Service("smsFlashPromotionProductRelationService")
public class SmsFlashPromotionProductRelationServiceImpl extends ServiceImpl<SmsFlashPromotionProductRelationDao, SmsFlashPromotionProductRelation> implements SmsFlashPromotionProductRelationService {

}
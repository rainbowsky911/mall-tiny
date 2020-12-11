package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsHomeRecommendProductDao;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeRecommendProduct;
import com.macro.mall.tiny.modules.sms.service.SmsHomeRecommendProductService;
import org.springframework.stereotype.Service;

/**
 * 人气推荐商品表(SmsHomeRecommendProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:03
 */
@Service("smsHomeRecommendProductService")
public class SmsHomeRecommendProductServiceImpl extends ServiceImpl<SmsHomeRecommendProductDao, SmsHomeRecommendProduct> implements SmsHomeRecommendProductService {

}
package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsCouponProductRelationDao;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponProductRelation;
import com.macro.mall.tiny.modules.sms.service.SmsCouponProductRelationService;
import org.springframework.stereotype.Service;

/**
 * 优惠券和产品的关系表(SmsCouponProductRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:58
 */
@Service("smsCouponProductRelationService")
public class SmsCouponProductRelationServiceImpl extends ServiceImpl<SmsCouponProductRelationDao, SmsCouponProductRelation> implements SmsCouponProductRelationService {

}
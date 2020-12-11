package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsCouponProductCategoryRelationDao;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponProductCategoryRelation;
import com.macro.mall.tiny.modules.sms.service.SmsCouponProductCategoryRelationService;
import org.springframework.stereotype.Service;

/**
 * 优惠券和产品分类关系表(SmsCouponProductCategoryRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:58
 */
@Service("smsCouponProductCategoryRelationService")
public class SmsCouponProductCategoryRelationServiceImpl extends ServiceImpl<SmsCouponProductCategoryRelationDao, SmsCouponProductCategoryRelation> implements SmsCouponProductCategoryRelationService {

}
package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsCouponDao;
import com.macro.mall.tiny.modules.sms.entity.SmsCoupon;
import com.macro.mall.tiny.modules.sms.service.SmsCouponService;
import org.springframework.stereotype.Service;

/**
 * 优惠卷表(SmsCoupon)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:56
 */
@Service("smsCouponService")
public class SmsCouponServiceImpl extends ServiceImpl<SmsCouponDao, SmsCoupon> implements SmsCouponService {

}
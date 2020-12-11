package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsCouponHistoryDao;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistory;
import com.macro.mall.tiny.modules.sms.service.SmsCouponHistoryService;
import org.springframework.stereotype.Service;

/**
 * 优惠券使用、领取历史表(SmsCouponHistory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:43:57
 */
@Service("smsCouponHistoryService")
public class SmsCouponHistoryServiceImpl extends ServiceImpl<SmsCouponHistoryDao, SmsCouponHistory> implements SmsCouponHistoryService {

}
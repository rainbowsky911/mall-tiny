package com.macro.mall.tiny.modules.sms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistory;
import com.macro.mall.tiny.modules.sms.entity.SmsCouponHistoryDetail;

import java.util.List;

/**
 * 优惠券使用、领取历史表(SmsCouponHistory)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:43:57
 */
public interface SmsCouponHistoryDao extends BaseMapper<SmsCouponHistory> {

    /**
     * 获取所有优惠券
     * @param id
     * @return
     */
    List<SmsCouponHistoryDetail> getDetailList(Long id);
}
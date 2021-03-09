package com.macro.mall.tiny.modules.oms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;

/**
 * 订单退货申请(OmsOrderReturnApply)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
public interface OmsOrderReturnApplyDao extends BaseMapper<OmsOrderReturnApply> {


    OmsOrderReturnApplyResult getItem(Long id);
}
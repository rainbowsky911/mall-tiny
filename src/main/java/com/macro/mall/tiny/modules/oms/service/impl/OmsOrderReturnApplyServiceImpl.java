package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderReturnApplyDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import org.springframework.stereotype.Service;

/**
 * 订单退货申请(OmsOrderReturnApply)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
@Service("omsOrderReturnApplyService")
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyDao, OmsOrderReturnApply> implements OmsOrderReturnApplyService {

}
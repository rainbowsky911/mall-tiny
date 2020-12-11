package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderReturnReasonDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnReason;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnReasonService;
import org.springframework.stereotype.Service;

/**
 * 退货原因表(OmsOrderReturnReason)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@Service("omsOrderReturnReasonService")
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonDao, OmsOrderReturnReason> implements OmsOrderReturnReasonService {

}
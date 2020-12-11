package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import com.macro.mall.tiny.modules.oms.service.OmsOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单表(OmsOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrder> implements OmsOrderService {

}
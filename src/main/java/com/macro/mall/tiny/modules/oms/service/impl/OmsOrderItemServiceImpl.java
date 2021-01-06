package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderItemDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.oms.service.OmsOrderItemService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单中所包含的商品(OmsOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@Service("omsOrderItemService")
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemDao, OmsOrderItem> implements OmsOrderItemService {

    @Autowired
    private OmsCartItemService orderItemService;

    @Autowired
    private UmsMemberService memberService;




}
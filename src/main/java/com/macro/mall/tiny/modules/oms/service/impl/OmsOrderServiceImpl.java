package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderDao;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderQueryParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import com.macro.mall.tiny.modules.oms.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单表(OmsOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrder> implements OmsOrderService {

    @Autowired
    private OmsOrderDao orderDao;

    @Override
    public IPage<OmsOrder> getList(Page page, OmsOrderQueryParam orderQueryParam) {
        return orderDao.getList(page, orderQueryParam);
    }

    @Override
    public Page<OmsOrder> getListNormal(Integer pageNum, Integer pageSize) {
        Page<OmsOrder> page = new Page<>(pageNum, pageSize);
        return page(page, new QueryWrapper<OmsOrder>());
    }
}
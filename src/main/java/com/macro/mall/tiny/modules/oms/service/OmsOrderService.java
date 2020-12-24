package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderQueryParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;

/**
 * 订单表(OmsOrder)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
public interface OmsOrderService extends IService<OmsOrder> {


    /**
     * 动态查询订单
     *
     * @param orderQueryParam
     * @return
     */
    IPage<OmsOrder> getList(Page page, OmsOrderQueryParam orderQueryParam);


    /**
     * 分页查询订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<OmsOrder> getListNormal(Integer pageNum, Integer pageSize);
}
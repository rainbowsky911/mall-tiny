package com.macro.mall.tiny.modules.oms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderQueryParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrder;
import org.apache.ibatis.annotations.Param;

/**
 * 订单表(OmsOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:31:51
 */
public interface OmsOrderDao extends BaseMapper<OmsOrder> {


    /**分页查询订单
     * @param page
     * @param orderQueryParam
     * @return
     */
    IPage<OmsOrder> getList(@Param("page") Page page, @Param("queryParam") OmsOrderQueryParam orderQueryParam);
}
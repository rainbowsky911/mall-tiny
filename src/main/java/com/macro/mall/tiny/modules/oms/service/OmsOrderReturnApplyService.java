package com.macro.mall.tiny.modules.oms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.modules.oms.dto.OmsReturnApplyQueryParam;
import com.macro.mall.tiny.modules.oms.dto.OmsUpdateStatusParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单退货申请(OmsOrderReturnApply)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApply> {



    OmsOrderReturnApplyResult getItem(Long id);


    /**
     * 退货申请分页查询
     * @param omsReturnApplyQueryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<OmsOrderReturnApply> getList(OmsReturnApplyQueryParam omsReturnApplyQueryParam, Integer pageSize, Integer pageNum);


    /**
     * 更新退货申请
     * @param omsUpdateStatusParam
     * @return
     */
    @Transactional
    int updateStatus(Long id,OmsUpdateStatusParam omsUpdateStatusParam);
}
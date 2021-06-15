package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderReturnApplyDao;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.modules.oms.dto.OmsReturnApplyQueryParam;
import com.macro.mall.tiny.modules.oms.dto.OmsUpdateStatusParam;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 订单退货申请(OmsOrderReturnApply)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
@Service("omsOrderReturnApplyService")
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyDao, OmsOrderReturnApply> implements OmsOrderReturnApplyService {

    @Autowired
    OmsOrderReturnApplyDao orderApplyDao;

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return orderApplyDao.getItem(id);
    }

    @Override
    public Page<OmsOrderReturnApply> getList(OmsReturnApplyQueryParam omsReturnApplyQueryParam, Integer pageSize, Integer pageNum) {
        Page<OmsOrderReturnApply> page = new Page<>(pageNum, pageSize);
        OmsOrderReturnApply orderReturnApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(omsReturnApplyQueryParam, orderReturnApply);

        LambdaQueryWrapper<OmsOrderReturnApply> wrapper = Wrappers.lambdaQuery(orderReturnApply);
        wrapper.eq(ObjectUtils.isNotEmpty(omsReturnApplyQueryParam.getStatus()), OmsOrderReturnApply::getStatus, omsReturnApplyQueryParam.getStatus());
        wrapper.eq(ObjectUtils.isNotEmpty(omsReturnApplyQueryParam.getId()), OmsOrderReturnApply::getId, omsReturnApplyQueryParam.getId());
        wrapper.eq(ObjectUtils.isNotEmpty(omsReturnApplyQueryParam.getHandleMan()), OmsOrderReturnApply::getHandleMan, omsReturnApplyQueryParam.getHandleMan());
        wrapper.likeRight(ObjectUtils.isNotEmpty(omsReturnApplyQueryParam.getHandleTime()), OmsOrderReturnApply::getHandleTime, omsReturnApplyQueryParam.getHandleTime());
        wrapper.likeRight(ObjectUtils.isNotEmpty(omsReturnApplyQueryParam.getCreateTime()), OmsOrderReturnApply::getCreateTime, omsReturnApplyQueryParam.getCreateTime());
        return page(page, wrapper);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam omsUpdateStatusParam) {
        OmsOrderReturnApply orderReturnApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(omsUpdateStatusParam, orderReturnApply);

        Integer status = omsUpdateStatusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if (status.equals(1)) {
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(omsUpdateStatusParam.getReturnAmount());
            returnApply.setCompanyAddressId(omsUpdateStatusParam.getCompanyAddressId());
            returnApply.setHandleTime(LocalDateTime.now());
            returnApply.setHandleMan(omsUpdateStatusParam.getHandleMan());
            returnApply.setHandleNote(omsUpdateStatusParam.getHandleNote());
        } else if (status.equals(2)) {
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(LocalDateTime.now());
            returnApply.setReceiveMan(omsUpdateStatusParam.getReceiveMan());
            returnApply.setReceiveNote(omsUpdateStatusParam.getReceiveNote());
        } else if (status.equals(3)) {
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(LocalDateTime.now());
            returnApply.setHandleMan(omsUpdateStatusParam.getHandleMan());
            returnApply.setHandleNote(omsUpdateStatusParam.getHandleNote());
        } else {
            return 0;
        }
        return updateById(returnApply) == true ? 1 : 0;
    }
}
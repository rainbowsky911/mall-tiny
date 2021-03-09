package com.macro.mall.tiny.modules.oms.dto;

import com.macro.mall.tiny.modules.oms.entity.OmsCompanyAddress;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by macro on 2018/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}


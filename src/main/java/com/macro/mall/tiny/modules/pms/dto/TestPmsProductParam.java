package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.entity.PmsMemberPrice;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Auther: zdw
 * @Date: 2021/06/10/2:08
 * @Description: 测试mybatis一对多查询
 */
public class TestPmsProductParam  extends PmsProduct {


    @ApiModelProperty("商品会员价格表")
    private List<PmsMemberPrice> memberPriceList;
}

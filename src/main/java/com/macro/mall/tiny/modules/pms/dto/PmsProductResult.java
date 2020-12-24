package com.macro.mall.tiny.modules.pms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询单个商品修改返回的结果
 */

@Data

public class PmsProductResult extends PmsProductParam {


    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}

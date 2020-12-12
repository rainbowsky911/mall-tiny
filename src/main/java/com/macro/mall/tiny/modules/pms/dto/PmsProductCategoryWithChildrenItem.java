package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class  PmsProductCategoryWithChildrenItem extends PmsProductCategory {

    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}

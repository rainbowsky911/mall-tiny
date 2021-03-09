package com.macro.mall.tiny.modules.ums.dto;

import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 * Created by macro on 2018/5/24.
 */
@Data
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}

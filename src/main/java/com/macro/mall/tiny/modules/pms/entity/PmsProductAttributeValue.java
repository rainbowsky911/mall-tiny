package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 存储产品参数信息的表(PmsProductAttributeValue)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsProductAttributeValue extends Model<PmsProductAttributeValue> {

    private Long id;

    private Long productId;

    private Long productAttributeId;
    //手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
    private String value;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
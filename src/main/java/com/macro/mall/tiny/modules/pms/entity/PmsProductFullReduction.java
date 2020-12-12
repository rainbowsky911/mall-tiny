package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 产品满减表(只针对同商品)(PmsProductFullReduction)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsProductFullReduction extends Model<PmsProductFullReduction> {

    private Long id;

    private Long productId;

    private Double fullPrice;

    private Double reducePrice;


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
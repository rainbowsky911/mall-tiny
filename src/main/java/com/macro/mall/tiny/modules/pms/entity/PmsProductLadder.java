package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 产品阶梯价格表(只针对同商品)(PmsProductLadder)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsProductLadder extends Model<PmsProductLadder> {

    private Long id;

    private Long productId;
    //满足的商品数量
    private Integer count;
    //折扣
    private Double discount;
    //折后价格
    private Double price;



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
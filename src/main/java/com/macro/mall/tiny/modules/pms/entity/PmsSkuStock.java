package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * sku的库存(PmsSkuStock)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:36
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsSkuStock extends Model<PmsSkuStock> {

    private Long id;

    private Long productId;
    //sku编码
    private String skuCode;

    private Double price;
    //库存
    private Integer stock;
    //预警库存
    private Integer lowStock;
    //展示图片
    private String pic;
    //销量
    private Integer sale;
    //单品促销价格
    private Double promotionPrice;
    //锁定库存
    private Integer lockStock;
    //商品销售属性，json格式
    private String spData;

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
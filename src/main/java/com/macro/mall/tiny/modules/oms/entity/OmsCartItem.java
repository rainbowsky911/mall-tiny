package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 购物车表(OmsCartItem)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:47
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsCartItem extends Model<OmsCartItem> {

    private Long id;

    private Long productId;

    private Long productSkuId;

    private Long memberId;
    //购买数量
    private Integer quantity;
    //添加到购物车的价格
    private Double price;
    //商品主图
    private String productPic;
    //商品名称
    private String productName;
    //商品副标题（卖点）
    private String productSubTitle;
    //商品sku条码
    private String productSkuCode;
    //会员昵称
    private String memberNickname;
    //创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    //修改时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyDate;
    //是否删除
    private Integer deleteStatus;
    //商品分类
    private Long productCategoryId;

    private String productBrand;

    private String productSn;
    //商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
    private String productAttr;


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
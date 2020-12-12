package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 商品会员价格表(PmsMemberPrice)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:30
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class PmsMemberPrice extends Model<PmsMemberPrice> {

    private Long id;

    private Long productId;

    private Long memberLevelId;
    //会员价格
    private Double memberPrice;

    private String memberLevelName;




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
package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 退货原因表(OmsOrderReturnReason)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsOrderReturnReason extends Model<OmsOrderReturnReason> {

    private Long id;
    //退货类型
    private String name;

    private Integer sort;
    //状态：0->不启用；1->启用
    private Integer status;
    //添加时间
    private LocalDateTime createTime;


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
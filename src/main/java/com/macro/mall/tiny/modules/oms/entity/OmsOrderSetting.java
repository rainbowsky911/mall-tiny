package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 订单设置表(OmsOrderSetting)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsOrderSetting extends Model<OmsOrderSetting> {

    private Long id;
    //秒杀订单超时关闭时间(分)
    private Integer flashOrderOvertime;
    //正常订单超时时间(分)
    private Integer normalOrderOvertime;
    //发货后自动确认收货时间（天）
    private Integer confirmOvertime;
    //自动完成交易时间，不能申请售后（天）
    private Integer finishOvertime;
    //订单完成后自动好评时间（天）
    private Integer commentOvertime;


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
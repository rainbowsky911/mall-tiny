package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 订单设置表(OmsOrderSetting)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:54
 */
@SuppressWarnings("serial")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlashOrderOvertime() {
        return flashOrderOvertime;
    }

    public void setFlashOrderOvertime(Integer flashOrderOvertime) {
        this.flashOrderOvertime = flashOrderOvertime;
    }

    public Integer getNormalOrderOvertime() {
        return normalOrderOvertime;
    }

    public void setNormalOrderOvertime(Integer normalOrderOvertime) {
        this.normalOrderOvertime = normalOrderOvertime;
    }

    public Integer getConfirmOvertime() {
        return confirmOvertime;
    }

    public void setConfirmOvertime(Integer confirmOvertime) {
        this.confirmOvertime = confirmOvertime;
    }

    public Integer getFinishOvertime() {
        return finishOvertime;
    }

    public void setFinishOvertime(Integer finishOvertime) {
        this.finishOvertime = finishOvertime;
    }

    public Integer getCommentOvertime() {
        return commentOvertime;
    }

    public void setCommentOvertime(Integer commentOvertime) {
        this.commentOvertime = commentOvertime;
    }

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
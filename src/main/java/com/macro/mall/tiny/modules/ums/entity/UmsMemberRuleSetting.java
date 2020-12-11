package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 会员积分成长规则表(UmsMemberRuleSetting)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:23
 */
@SuppressWarnings("serial")
public class UmsMemberRuleSetting extends Model<UmsMemberRuleSetting> {

    private Long id;
    //连续签到天数
    private Integer continueSignDay;
    //连续签到赠送数量
    private Integer continueSignPoint;
    //每消费多少元获取1个点
    private Double consumePerPoint;
    //最低获取点数的订单金额
    private Double lowOrderAmount;
    //每笔订单最高获取点数
    private Integer maxPointPerOrder;
    //类型：0->积分规则；1->成长值规则
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContinueSignDay() {
        return continueSignDay;
    }

    public void setContinueSignDay(Integer continueSignDay) {
        this.continueSignDay = continueSignDay;
    }

    public Integer getContinueSignPoint() {
        return continueSignPoint;
    }

    public void setContinueSignPoint(Integer continueSignPoint) {
        this.continueSignPoint = continueSignPoint;
    }

    public Double getConsumePerPoint() {
        return consumePerPoint;
    }

    public void setConsumePerPoint(Double consumePerPoint) {
        this.consumePerPoint = consumePerPoint;
    }

    public Double getLowOrderAmount() {
        return lowOrderAmount;
    }

    public void setLowOrderAmount(Double lowOrderAmount) {
        this.lowOrderAmount = lowOrderAmount;
    }

    public Integer getMaxPointPerOrder() {
        return maxPointPerOrder;
    }

    public void setMaxPointPerOrder(Integer maxPointPerOrder) {
        this.maxPointPerOrder = maxPointPerOrder;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
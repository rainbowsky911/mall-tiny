package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 积分消费设置(UmsIntegrationConsumeSetting)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:18
 */
@SuppressWarnings("serial")
public class UmsIntegrationConsumeSetting extends Model<UmsIntegrationConsumeSetting> {

    private Long id;
    //每一元需要抵扣的积分数量
    private Integer deductionPerAmount;
    //每笔订单最高抵用百分比
    private Integer maxPercentPerOrder;
    //每次使用积分最小单位100
    private Integer useUnit;
    //是否可以和优惠券同用；0->不可以；1->可以
    private Integer couponStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeductionPerAmount() {
        return deductionPerAmount;
    }

    public void setDeductionPerAmount(Integer deductionPerAmount) {
        this.deductionPerAmount = deductionPerAmount;
    }

    public Integer getMaxPercentPerOrder() {
        return maxPercentPerOrder;
    }

    public void setMaxPercentPerOrder(Integer maxPercentPerOrder) {
        this.maxPercentPerOrder = maxPercentPerOrder;
    }

    public Integer getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(Integer useUnit) {
        this.useUnit = useUnit;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
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
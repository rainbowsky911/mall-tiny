package com.macro.mall.tiny.modules.pms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 运费模版(PmsFeightTemplate)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:40:29
 */
@SuppressWarnings("serial")
public class PmsFeightTemplate extends Model<PmsFeightTemplate> {

    private Long id;

    private String name;
    //计费类型:0->按重量；1->按件数
    private Integer chargeType;
    //首重kg
    private Double firstWeight;
    //首费（元）
    private Double firstFee;

    private Double continueWeight;

    private Double continmeFee;
    //目的地（省、市）
    private String dest;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Double getFirstFee() {
        return firstFee;
    }

    public void setFirstFee(Double firstFee) {
        this.firstFee = firstFee;
    }

    public Double getContinueWeight() {
        return continueWeight;
    }

    public void setContinueWeight(Double continueWeight) {
        this.continueWeight = continueWeight;
    }

    public Double getContinmeFee() {
        return continmeFee;
    }

    public void setContinmeFee(Double continmeFee) {
        this.continmeFee = continmeFee;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
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
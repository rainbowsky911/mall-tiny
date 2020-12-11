package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户标签表(UmsMemberTag)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:24
 */
@SuppressWarnings("serial")
public class UmsMemberTag extends Model<UmsMemberTag> {

    private Long id;

    private String name;
    //自动打标签完成订单数量
    private Integer finishOrderCount;
    //自动打标签完成订单金额
    private Double finishOrderAmount;


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

    public Integer getFinishOrderCount() {
        return finishOrderCount;
    }

    public void setFinishOrderCount(Integer finishOrderCount) {
        this.finishOrderCount = finishOrderCount;
    }

    public Double getFinishOrderAmount() {
        return finishOrderAmount;
    }

    public void setFinishOrderAmount(Double finishOrderAmount) {
        this.finishOrderAmount = finishOrderAmount;
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
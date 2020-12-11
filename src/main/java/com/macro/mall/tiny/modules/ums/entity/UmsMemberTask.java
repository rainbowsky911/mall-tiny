package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 会员任务表(UmsMemberTask)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:25
 */
@SuppressWarnings("serial")
public class UmsMemberTask extends Model<UmsMemberTask> {

    private Long id;

    private String name;
    //赠送成长值
    private Integer growth;
    //赠送积分
    private Integer intergration;
    //任务类型：0->新手任务；1->日常任务
    private Integer type;


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

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getIntergration() {
        return intergration;
    }

    public void setIntergration(Integer intergration) {
        this.intergration = intergration;
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
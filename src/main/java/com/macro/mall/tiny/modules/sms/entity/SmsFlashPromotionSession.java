package com.macro.mall.tiny.modules.sms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 限时购场次表(SmsFlashPromotionSession)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:44:00
 */
@SuppressWarnings("serial")
public class SmsFlashPromotionSession extends Model<SmsFlashPromotionSession> {
    //编号
    private Long id;
    //场次名称
    private String name;
    //每日开始时间
    private Object startTime;
    //每日结束时间
    private Object endTime;
    //启用状态：0->不启用；1->启用
    private Integer status;
    //创建时间
    private LocalDateTime createTime;


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

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
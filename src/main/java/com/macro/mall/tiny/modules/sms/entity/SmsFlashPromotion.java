package com.macro.mall.tiny.modules.sms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 限时购表(SmsFlashPromotion)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:43:59
 */
@SuppressWarnings("serial")
public class SmsFlashPromotion extends Model<SmsFlashPromotion> {

    private Long id;

    private String title;
    //开始日期
    private Date startDate;
    //结束日期
    private Date endDate;
    //上下线状态
    private Integer status;
    //秒杀时间段名称
    private LocalDateTime createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
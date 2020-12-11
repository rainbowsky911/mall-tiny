package com.macro.mall.tiny.modules.cms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

/**
 * 用户举报表(CmsMemberReport)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:20:13
 */
@SuppressWarnings("serial")
public class CmsMemberReport extends Model<CmsMemberReport> {

    private Long id;
    //举报类型：0->商品评价；1->话题内容；2->用户评论
    private Integer reportType;
    //举报人
    private String reportMemberName;

    private LocalDateTime createTime;

    private String reportObject;
    //举报状态：0->未处理；1->已处理
    private Integer reportStatus;
    //处理结果：0->无效；1->有效；2->恶意
    private Integer handleStatus;

    private String note;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getReportMemberName() {
        return reportMemberName;
    }

    public void setReportMemberName(String reportMemberName) {
        this.reportMemberName = reportMemberName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getReportObject() {
        return reportObject;
    }

    public void setReportObject(String reportObject) {
        this.reportObject = reportObject;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
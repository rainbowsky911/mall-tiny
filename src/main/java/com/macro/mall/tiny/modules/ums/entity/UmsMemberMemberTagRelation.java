package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户和标签关系表(UmsMemberMemberTagRelation)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:21
 */
@SuppressWarnings("serial")
public class UmsMemberMemberTagRelation extends Model<UmsMemberMemberTagRelation> {

    private Long id;

    private Long memberId;

    private Long tagId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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
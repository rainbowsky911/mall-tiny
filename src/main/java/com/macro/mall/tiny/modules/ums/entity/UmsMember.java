package com.macro.mall.tiny.modules.ums.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 会员表(UmsMember)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:46:19
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class UmsMember extends Model<UmsMember> {

    private Long id;

    private Long memberLevelId;
    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickname;
    //手机号码
    private String phone;
    //帐号启用状态:0->禁用；1->启用
    private Integer status;
    //注册时间
    private LocalDateTime createTime;
    //头像
    private String icon;
    //性别：0->未知；1->男；2->女
    private Integer gender;
    //生日
    private Date birthday;
    //所做城市
    private String city;
    //职业
    private String job;
    //个性签名
    private String personalizedSignature;
    //用户来源
    private Integer sourceType;
    //积分
    private Integer integration;
    //成长值
    private Integer growth;
    //剩余抽奖次数
    private Integer luckeyCount;
    //历史积分数量
    private Integer historyIntegration;




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
package com.macro.mall.tiny.modules.sms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 限时购场次表(SmsFlashPromotionSession)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:44:00
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class SmsFlashPromotionSession extends Model<SmsFlashPromotionSession> {
    //编号
    private Long id;
    //场次名称
    private String name;
    //每日开始时间
    private Date startTime;
    //每日结束时间
    private Date endTime;
    //启用状态：0->不启用；1->启用
    private Integer status;
    //创建时间
    private LocalDateTime createTime;


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
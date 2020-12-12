package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 订单操作历史记录(OmsOrderOperateHistory)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:52
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsOrderOperateHistory extends Model<OmsOrderOperateHistory> {

    private Long id;
    //订单id
    private Long orderId;
    //操作人：用户；系统；后台管理员
    private String operateMan;
    //操作时间
    private LocalDateTime createTime;
    //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    private Integer orderStatus;
    //备注
    private String note;



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
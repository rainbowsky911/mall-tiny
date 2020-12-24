package com.macro.mall.tiny.modules.oms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 公司收发货地址表(OmsCompanyAddress)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:31:51
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class OmsCompanyAddress extends Model<OmsCompanyAddress> {

    private Long id;
    //地址名称
    private String addressName;
    //默认发货地址：0->否；1->是
    private Integer sendStatus;
    //是否默认收货地址：0->否；1->是
    private Integer receiveStatus;
    //收发货人姓名
    private String name;
    //收货人电话
    private String phone;
    //省/直辖市
    private String province;
    //市
    private String city;
    //区
    private String region;
    //详细地址
    private String detailAddress;


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
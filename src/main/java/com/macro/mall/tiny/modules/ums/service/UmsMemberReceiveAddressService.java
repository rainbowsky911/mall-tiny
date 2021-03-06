package com.macro.mall.tiny.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址表(UmsMemberReceiveAddress)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:46:22
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddress> {


    /**
     * 返回当前用户收获地址
     *
     * @return
     */
    List<UmsMemberReceiveAddress> memberReceiveAddressList();

}
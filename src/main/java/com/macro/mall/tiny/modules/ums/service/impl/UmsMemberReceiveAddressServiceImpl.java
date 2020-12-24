package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberReceiveAddressDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberReceiveAddress;
import com.macro.mall.tiny.modules.ums.service.UmsMemberReceiveAddressService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员收货地址表(UmsMemberReceiveAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:22
 */
@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressDao, UmsMemberReceiveAddress> implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberService memberService;

    @Override
    public List<UmsMemberReceiveAddress> memberReceiveAddressList() {

        return list(new LambdaQueryWrapper<UmsMemberReceiveAddress>()
                .eq(UmsMemberReceiveAddress::getMemberId, memberService.getCurrentMember().getId()));
    }
}
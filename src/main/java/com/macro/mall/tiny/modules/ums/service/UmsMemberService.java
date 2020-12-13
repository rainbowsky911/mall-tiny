package com.macro.mall.tiny.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;

/**
 * 会员表(UmsMember)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:46:19
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**获取当前登录会员
     * @return
     */
    UmsMember getCurrentMember();
}
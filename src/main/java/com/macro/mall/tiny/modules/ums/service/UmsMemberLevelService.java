package com.macro.mall.tiny.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级表(UmsMemberLevel)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:46:20
 */
public interface UmsMemberLevelService extends IService<UmsMemberLevel> {

    /**
     * 查询会员等级
     *
     * @param defaultStatus
     * @return
     */
    List<UmsMemberLevel> getMemberLevelList(Long defaultStatus);
}
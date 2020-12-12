package com.macro.mall.tiny.modules.ums.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberLevelDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLevel;
import com.macro.mall.tiny.modules.ums.service.UmsMemberLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级表(UmsMemberLevel)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:20
 */
@Service("umsMemberLevelService")
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelDao, UmsMemberLevel> implements UmsMemberLevelService {

    @Override
    public List<UmsMemberLevel> getMemberLevelList(Long defaultStatus) {

        return list(new LambdaQueryWrapper<UmsMemberLevel>()
                .eq(ObjectUtil.isNotNull(defaultStatus), UmsMemberLevel::getDefaultStatus, defaultStatus));
    }
}
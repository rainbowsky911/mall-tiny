package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberLevelDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberLevel;
import com.macro.mall.tiny.modules.ums.service.UmsMemberLevelService;
import org.springframework.stereotype.Service;

/**
 * 会员等级表(UmsMemberLevel)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:20
 */
@Service("umsMemberLevelService")
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelDao, UmsMemberLevel> implements UmsMemberLevelService {

}
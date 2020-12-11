package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberTagDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberTag;
import com.macro.mall.tiny.modules.ums.service.UmsMemberTagService;
import org.springframework.stereotype.Service;

/**
 * 用户标签表(UmsMemberTag)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:24
 */
@Service("umsMemberTagService")
public class UmsMemberTagServiceImpl extends ServiceImpl<UmsMemberTagDao, UmsMemberTag> implements UmsMemberTagService {

}
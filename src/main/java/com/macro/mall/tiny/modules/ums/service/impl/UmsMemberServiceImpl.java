package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.stereotype.Service;

/**
 * 会员表(UmsMember)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:19
 */
@Service("umsMemberService")
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberDao, UmsMember> implements UmsMemberService {

}
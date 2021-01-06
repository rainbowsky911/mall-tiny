package com.macro.mall.tiny.modules.ums.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.common.AuthConstant;
import com.macro.mall.tiny.common.api.ResultCode;
import com.macro.mall.tiny.common.domain.UserDto;
import com.macro.mall.tiny.common.exception.Asserts;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.service.UmsMemberCacheService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员表(UmsMember)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:19
 */
@Service("umsMemberService")
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberDao, UmsMember> implements UmsMemberService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UmsMemberCacheService memberCacheService;

    @Override
    public UmsMember getCurrentMember() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StrUtil.isEmpty(userStr)) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsMember member = memberCacheService.getMember(userDto.getId());
        if (member != null) {
            return member;
        } else {
            member = getById(userDto.getId());
            memberCacheService.setMember(member);
            return member;
        }
    }

    @Override
    public int updateIntegration(Long memberId, Integer integration) {
        int count = 0;
        if (memberId != null && integration != null) {
            boolean status = update(new LambdaUpdateWrapper<UmsMember>()
                    .eq(UmsMember::getId, memberId)
                    .set(UmsMember::getIntegration, integration));
            if (status) {
                count = 1;
            } else {
                count = 0;
            }
        }
        return count;
    }
}
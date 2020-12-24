package com.macro.mall.tiny.modules.ums.service.impl;


import com.macro.mall.tiny.common.service.RedisService;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.service.UmsMemberCacheService;
import com.macro.mall.tiny.security.annotation.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UmsMemberCacheService实现类
 */
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
    @Autowired
    private RedisService redisService;

    private String REDIS_DATABASE = "9";

    private Long REDIS_EXPIRE = 86400L;

    private Long REDIS_EXPIRE_AUTH_CODE = 90L;


    private String REDIS_KEY_MEMBER = "ums:member";

    private String REDIS_KEY_AUTH_CODE = "ums:authCode";

    @Override
    public void delMember(Long memberId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + memberId;
        redisService.del(key);
    }

    @Override
    public UmsMember getMember(Long memberId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + memberId;
        return (UmsMember) redisService.get(key);
    }

    @Override
    public void setMember(UmsMember member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getId();
        redisService.set(key, member, REDIS_EXPIRE);
    }

    @CacheException
    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
    }

    @CacheException
    @Override
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        return (String) redisService.get(key);
    }
}

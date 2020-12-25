package com.macro.mall.tiny.modules.ums.service;

import com.macro.mall.tiny.modules.ums.entity.MemberBrandAttention;
import org.springframework.data.domain.Page;

public interface MemberAttentionService {


    /**
     * 添加关注
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     *
     * @param brandId
     * @return
     */
    int delete(Long brandId);

    /**
     * 清空关注
     */
    void clear();

    MemberBrandAttention detail(Long brandId);

    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);
}

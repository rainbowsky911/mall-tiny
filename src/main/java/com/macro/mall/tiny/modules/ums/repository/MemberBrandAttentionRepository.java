package com.macro.mall.tiny.modules.ums.repository;

import com.macro.mall.tiny.modules.ums.entity.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员关注Repository
 * Created by macro on 2018/8/2.
 */
public interface MemberBrandAttentionRepository
        extends MongoRepository<MemberBrandAttention,String> {
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);

    int  deleteByMemberIdAndBrandId(Long memberId, Long brandId);


    /**
     * 清空列表
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);

    /**
     * 获取用户关注列表
     * @param id
     * @param pageable
     * @return
     */
    Page<MemberBrandAttention> findByMemberId(Long id, Pageable pageable);
}

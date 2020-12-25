package com.macro.mall.tiny.modules.ums.repository;

import com.macro.mall.tiny.modules.ums.entity.MemberProductCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberCollectionRepository

        extends MongoRepository<MemberProductCollection, String> {


    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);

    int deleteByMemberIdAndProductId(Long id, Long productId);

    Page<MemberProductCollection> findByMemberId(Long id, Pageable pageable);

    void deleteAllByMemberId(Long id);
}

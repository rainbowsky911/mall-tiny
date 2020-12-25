package com.macro.mall.tiny.modules.ums.service.impl;

import com.macro.mall.tiny.modules.ums.entity.MemberProductCollection;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.repository.MemberCollectionRepository;
import com.macro.mall.tiny.modules.ums.service.MemberCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberCollectionServiceImpl implements MemberCollectionService {

    @Autowired
    private MemberCollectionRepository memberCollectionRepository;


    @Override
    public int add(MemberProductCollection productCollection) {

        int count = 0;
        // UmsMember member = memberService.getCurrentMember();
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        productCollection.setMemberId(member.getId());
        productCollection.setMemberNickname(member.getNickname());
        productCollection.setMemberIcon(member.getIcon());
        productCollection.setCreateTime(new Date());
        MemberProductCollection collection = memberCollectionRepository.
                findByMemberIdAndProductId(productCollection.getMemberId(), productCollection.getProductId());

        if (collection == null) {
            memberCollectionRepository.save(productCollection);
            count = 1;
        }
        return count;
    }

    @Override
    public int delete(Long productId) {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
       return memberCollectionRepository.deleteByMemberIdAndProductId(member.getId(),productId);
    }

    @Override
    public Page<MemberProductCollection> list(Integer pageNum, Integer pageSize) {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return memberCollectionRepository.findByMemberId(member.getId(), pageable);
    }

    @Override
    public MemberProductCollection detail(Long productId) {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        return memberCollectionRepository.findByMemberIdAndProductId(member.getId(), productId);
    }

    @Override
    public void clear() {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        memberCollectionRepository.deleteAllByMemberId(member.getId());
    }
}

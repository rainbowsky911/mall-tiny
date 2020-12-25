package com.macro.mall.tiny.modules.ums.service.impl;

import com.macro.mall.tiny.modules.ums.entity.MemberBrandAttention;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
import com.macro.mall.tiny.modules.ums.repository.MemberBrandAttentionRepository;
import com.macro.mall.tiny.modules.ums.service.MemberAttentionService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MemberAttentionServiceImpl implements MemberAttentionService {

    @Autowired
    private MemberBrandAttentionRepository memberBrandAttentionRepository;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public int add(MemberBrandAttention memberBrandAttention) {

        int count = 0;
        // UmsMember member = memberService.getCurrentMember();
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        memberBrandAttention.setMemberId(member.getId());
        memberBrandAttention.setMemberNickname(member.getNickname());
        memberBrandAttention.setMemberIcon(member.getIcon());
        memberBrandAttention.setCreateTime(new Date());
        MemberBrandAttention repository = memberBrandAttentionRepository.
                findByMemberIdAndBrandId(memberBrandAttention.getMemberId(), memberBrandAttention.getBrandId());

        if (repository == null) {
            memberBrandAttentionRepository.save(memberBrandAttention);
            count = 1;
        }
        return count;
    }

    @Override
    public int delete(Long brandId) {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        return  memberBrandAttentionRepository.deleteByMemberIdAndBrandId(member.getId(), brandId);

    }

    @Override
    public void clear() {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        memberBrandAttentionRepository.deleteAllByMemberId(member.getId());

    }

    @Override
    public MemberBrandAttention detail(Long brandId) {
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        return memberBrandAttentionRepository.findByMemberIdAndBrandId(member.getId(), brandId);
    }

    @Override
    public Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        UmsMember member = new UmsMember().setId(1L).setNickname("kobe").setIcon("xxx");
        return memberBrandAttentionRepository.findByMemberId(member.getId(), pageable);
    }
}

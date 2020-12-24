package com.macro.mall.tiny.modules.oms.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsCartItemDao;
import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.oms.service.OmsPromotionService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 购物车表(OmsCartItem)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:50
 */
@Service("omsCartItemService")
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemDao, OmsCartItem> implements OmsCartItemService {

    @Autowired
    private OmsPromotionService promotionService;

    @Autowired
    private UmsMemberService memberService;

    @Override
    public int add(OmsCartItem cartItem) {
        int count = 0;
       /* UmsMember member = memberService.getCurrentMember();
        cartItem.setMemberId(member.getId());
        cartItem.setDeleteStatus(0);
        cartItem.setMemberNickname(member.getNickname());
*/
        OmsCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null) {
            cartItem.setCreateDate(LocalDateTime.now());
            save(cartItem);
        } else {
            existCartItem.setModifyDate(LocalDateTime.now());
            existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
            updateById(existCartItem);
        }
        return count;
    }

    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds) {
        List<OmsCartItem> cartItemList = list(memberId);
        if (CollUtil.isNotEmpty(cartIds)) {
            cartItemList = cartItemList.stream().filter(item -> cartIds.contains(item.getId())).collect(Collectors.toList());
        }
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(cartItemList)) {
            cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
        }
        return cartPromotionItemList;
    }


    public List<OmsCartItem> list(Long memberId) {
        return list(new LambdaQueryWrapper<OmsCartItem>()
                .eq(!ObjectUtils.isEmpty(memberId), OmsCartItem::getMemberId, memberId)
                .eq(OmsCartItem::getDeleteStatus, 0));
    }


    public OmsCartItem getCartItem(OmsCartItem omsCartItem) {

        LambdaQueryWrapper<OmsCartItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OmsCartItem::getProductId, omsCartItem.getProductId());
        wrapper.eq(OmsCartItem::getMemberId, omsCartItem.getMemberId());
        wrapper.eq(OmsCartItem::getProductSkuId, omsCartItem.getProductSkuId());

        List<OmsCartItem> list = list(wrapper);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
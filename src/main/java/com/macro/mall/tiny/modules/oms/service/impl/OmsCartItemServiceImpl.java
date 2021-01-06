package com.macro.mall.tiny.modules.oms.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsCartItemDao;
import com.macro.mall.tiny.modules.oms.dao.PortalProductDao;
import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.entity.CartProduct;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.oms.service.OmsPromotionService;
import com.macro.mall.tiny.modules.ums.entity.UmsMember;
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


    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public int add(OmsCartItem cartItem) {
        int count = 0;
        // UmsMember member = memberService.getCurrentMember();

        UmsMember member = new UmsMember().setId(1L).setNickname("jack");
        cartItem.setMemberId(member.getId());
        cartItem.setDeleteStatus(0);
        cartItem.setMemberNickname(member.getNickname());
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

    @Override
    public int updateQuantity(Long id, Integer quantity) {
        boolean update = update(new LambdaUpdateWrapper<OmsCartItem>()
                .set(OmsCartItem::getQuantity, quantity)
                .eq(OmsCartItem::getId, id)
                .eq(OmsCartItem::getMemberId, 1));
        if (update) {
            return 1;
        } else {

            return 0;
        }
    }

    @Override
    public int clearOmsCartItems() {
        boolean update = update(new LambdaUpdateWrapper<OmsCartItem>()
                .set(OmsCartItem::getDeleteStatus, 1)
                .eq(OmsCartItem::getMemberId, 1));
        if (update) {
            return 1;
        } else {

            return 0;
        }

    }

    @Override
    public int delete(List<Long> ids) {
        boolean update = update(new LambdaUpdateWrapper<OmsCartItem>()
                .set(OmsCartItem::getDeleteStatus, 1)
                .eq(OmsCartItem::getMemberId, 1)
                .in(OmsCartItem::getId, ids));
        if (update) {
            return 1;
        } else {

            return 0;
        }
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        /**
         * 删除原购物车信息
         */
        OmsCartItem updateCart = new OmsCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(LocalDateTime.now());
        updateCart.setDeleteStatus(1);
        updateById(updateCart);

        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public CartProduct getCartProduct(Long productId) {

        portalProductDao.getCartProduct(productId);
        return null;
    }

    @Override
    public List<OmsCartItem> getOmsCartByUserId(long memberId) {
        return list( new LambdaQueryWrapper<OmsCartItem>().eq(OmsCartItem::getMemberId, memberId)
                .eq(OmsCartItem::getDeleteStatus,0));
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
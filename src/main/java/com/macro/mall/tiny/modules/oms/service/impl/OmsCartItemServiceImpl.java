package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsCartItemDao;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import com.macro.mall.tiny.modules.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 购物车表(OmsCartItem)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:50
 */
@Service("omsCartItemService")
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemDao, OmsCartItem> implements OmsCartItemService {

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
        count =1;
        return count;
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
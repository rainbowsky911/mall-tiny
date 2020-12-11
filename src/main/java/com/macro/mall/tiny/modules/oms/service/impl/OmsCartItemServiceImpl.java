package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsCartItemDao;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import org.springframework.stereotype.Service;

/**
 * 购物车表(OmsCartItem)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:50
 */
@Service("omsCartItemService")
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemDao, OmsCartItem> implements OmsCartItemService {

}
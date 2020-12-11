package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsMemberPriceDao;
import com.macro.mall.tiny.modules.pms.entity.PmsMemberPrice;
import com.macro.mall.tiny.modules.pms.service.PmsMemberPriceService;
import org.springframework.stereotype.Service;

/**
 * 商品会员价格表(PmsMemberPrice)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:30
 */
@Service("pmsMemberPriceService")
public class PmsMemberPriceServiceImpl extends ServiceImpl<PmsMemberPriceDao, PmsMemberPrice> implements PmsMemberPriceService {

}
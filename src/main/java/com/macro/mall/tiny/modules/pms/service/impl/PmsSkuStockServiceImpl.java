package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsSkuStockDao;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import com.macro.mall.tiny.modules.pms.service.PmsSkuStockService;
import org.springframework.stereotype.Service;

/**
 * sku的库存(PmsSkuStock)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:42:59
 */
@Service("pmsSkuStockService")
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockDao, PmsSkuStock> implements PmsSkuStockService {

}
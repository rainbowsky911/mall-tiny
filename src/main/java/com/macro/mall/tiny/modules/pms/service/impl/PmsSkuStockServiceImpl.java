package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderItem;
import com.macro.mall.tiny.modules.pms.dao.PmsSkuStockDao;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import com.macro.mall.tiny.modules.pms.service.PmsSkuStockService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * sku的库存(PmsSkuStock)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:42:59
 */
@Service("pmsSkuStockService")
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockDao, PmsSkuStock> implements PmsSkuStockService {

    @Override
    public List<PmsSkuStock> getProductId(Long id) {
        return list(new LambdaQueryWrapper<PmsSkuStock>()
                .eq(ObjectUtils.isNotEmpty(id), PmsSkuStock::getProductId, id));

    }

    @Override
    public int releaseSkuStockLock(List<OmsOrderItem> orderItemList) {

        AtomicInteger count = new AtomicInteger();
        orderItemList.stream().forEach(e -> {
            boolean status = update(new LambdaUpdateWrapper<PmsSkuStock>()
                    .setSql("lock_stock=lock_stock-1")
                    .eq(PmsSkuStock::getId, e.getId() + 0L));
            if (status) {
                count.set(1);
            } else {
                count.set(0);
            }
        });


        return count.get();
    }
}
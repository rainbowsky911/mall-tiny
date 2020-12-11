package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductFullReductionDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductFullReduction;
import com.macro.mall.tiny.modules.pms.service.PmsProductFullReductionService;
import org.springframework.stereotype.Service;

/**
 * 产品满减表(只针对同商品)(PmsProductFullReduction)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@Service("pmsProductFullReductionService")
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionDao, PmsProductFullReduction> implements PmsProductFullReductionService {

}
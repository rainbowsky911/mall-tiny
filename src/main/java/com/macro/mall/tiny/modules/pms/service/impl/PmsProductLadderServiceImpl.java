package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductLadderDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductLadder;
import com.macro.mall.tiny.modules.pms.service.PmsProductLadderService;
import org.springframework.stereotype.Service;

/**
 * 产品阶梯价格表(只针对同商品)(PmsProductLadder)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:34
 */
@Service("pmsProductLadderService")
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderDao, PmsProductLadder> implements PmsProductLadderService {

}
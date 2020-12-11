package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductAttributeValueDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeValue;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeValueService;
import org.springframework.stereotype.Service;

/**
 * 存储产品参数信息的表(PmsProductAttributeValue)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
@Service("pmsProductAttributeValueService")
public class PmsProductAttributeValueServiceImpl extends ServiceImpl<PmsProductAttributeValueDao, PmsProductAttributeValue> implements PmsProductAttributeValueService {

}
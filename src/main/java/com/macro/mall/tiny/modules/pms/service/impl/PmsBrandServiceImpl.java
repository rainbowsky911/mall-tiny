package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsBrandDao;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.service.PmsBrandService;
import org.springframework.stereotype.Service;

/**
 * 品牌表(PmsBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@Service("pmsBrandService")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrand> implements PmsBrandService {

}
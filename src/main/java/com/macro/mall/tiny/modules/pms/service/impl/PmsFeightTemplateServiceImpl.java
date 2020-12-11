package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsFeightTemplateDao;
import com.macro.mall.tiny.modules.pms.entity.PmsFeightTemplate;
import com.macro.mall.tiny.modules.pms.service.PmsFeightTemplateService;
import org.springframework.stereotype.Service;

/**
 * 运费模版(PmsFeightTemplate)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:30
 */
@Service("pmsFeightTemplateService")
public class PmsFeightTemplateServiceImpl extends ServiceImpl<PmsFeightTemplateDao, PmsFeightTemplate> implements PmsFeightTemplateService {

}
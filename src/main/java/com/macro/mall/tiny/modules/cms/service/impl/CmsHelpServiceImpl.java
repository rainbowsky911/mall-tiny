package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsHelpDao;
import com.macro.mall.tiny.modules.cms.entity.CmsHelp;
import com.macro.mall.tiny.modules.cms.service.CmsHelpService;
import org.springframework.stereotype.Service;

/**
 * 帮助表(CmsHelp)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:12
 */
@Service("cmsHelpService")
public class CmsHelpServiceImpl extends ServiceImpl<CmsHelpDao, CmsHelp> implements CmsHelpService {

}
package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsTopicDao;
import com.macro.mall.tiny.modules.cms.entity.CmsTopic;
import com.macro.mall.tiny.modules.cms.service.CmsTopicService;
import org.springframework.stereotype.Service;

/**
 * 话题表(CmsTopic)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:17
 */
@Service("cmsTopicService")
public class CmsTopicServiceImpl extends ServiceImpl<CmsTopicDao, CmsTopic> implements CmsTopicService {

}
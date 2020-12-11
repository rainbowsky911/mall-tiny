package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsTopicCommentDao;
import com.macro.mall.tiny.modules.cms.entity.CmsTopicComment;
import com.macro.mall.tiny.modules.cms.service.CmsTopicCommentService;
import org.springframework.stereotype.Service;

/**
 * 专题评论表(CmsTopicComment)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:19
 */
@Service("cmsTopicCommentService")
public class CmsTopicCommentServiceImpl extends ServiceImpl<CmsTopicCommentDao, CmsTopicComment> implements CmsTopicCommentService {

}
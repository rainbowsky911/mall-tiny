package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsSubjectCommentDao;
import com.macro.mall.tiny.modules.cms.entity.CmsSubjectComment;
import com.macro.mall.tiny.modules.cms.service.CmsSubjectCommentService;
import org.springframework.stereotype.Service;

/**
 * 专题评论表(CmsSubjectComment)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:16
 */
@Service("cmsSubjectCommentService")
public class CmsSubjectCommentServiceImpl extends ServiceImpl<CmsSubjectCommentDao, CmsSubjectComment> implements CmsSubjectCommentService {

}
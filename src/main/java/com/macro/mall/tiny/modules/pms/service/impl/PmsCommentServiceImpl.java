package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsCommentDao;
import com.macro.mall.tiny.modules.pms.entity.PmsComment;
import com.macro.mall.tiny.modules.pms.service.PmsCommentService;
import org.springframework.stereotype.Service;

/**
 * 商品评价表(PmsComment)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:29
 */
@Service("pmsCommentService")
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentDao, PmsComment> implements PmsCommentService {

}
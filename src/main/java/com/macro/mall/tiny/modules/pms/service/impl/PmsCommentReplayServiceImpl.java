package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsCommentReplayDao;
import com.macro.mall.tiny.modules.pms.entity.PmsCommentReplay;
import com.macro.mall.tiny.modules.pms.service.PmsCommentReplayService;
import org.springframework.stereotype.Service;

/**
 * 产品评价回复表(PmsCommentReplay)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:29
 */
@Service("pmsCommentReplayService")
public class PmsCommentReplayServiceImpl extends ServiceImpl<PmsCommentReplayDao, PmsCommentReplay> implements PmsCommentReplayService {

}
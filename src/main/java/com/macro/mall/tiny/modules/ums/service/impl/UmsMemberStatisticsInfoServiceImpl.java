package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsMemberStatisticsInfoDao;
import com.macro.mall.tiny.modules.ums.entity.UmsMemberStatisticsInfo;
import com.macro.mall.tiny.modules.ums.service.UmsMemberStatisticsInfoService;
import org.springframework.stereotype.Service;

/**
 * 会员统计信息(UmsMemberStatisticsInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:24
 */
@Service("umsMemberStatisticsInfoService")
public class UmsMemberStatisticsInfoServiceImpl extends ServiceImpl<UmsMemberStatisticsInfoDao, UmsMemberStatisticsInfo> implements UmsMemberStatisticsInfoService {

}
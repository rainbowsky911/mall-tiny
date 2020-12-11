package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dao.UmsGrowthChangeHistoryDao;
import com.macro.mall.tiny.modules.ums.entity.UmsGrowthChangeHistory;
import com.macro.mall.tiny.modules.ums.service.UmsGrowthChangeHistoryService;
import org.springframework.stereotype.Service;

/**
 * 成长值变化历史记录表(UmsGrowthChangeHistory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:46:17
 */
@Service("umsGrowthChangeHistoryService")
public class UmsGrowthChangeHistoryServiceImpl extends ServiceImpl<UmsGrowthChangeHistoryDao, UmsGrowthChangeHistory> implements UmsGrowthChangeHistoryService {

}
package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsOrderOperateHistoryDao;
import com.macro.mall.tiny.modules.oms.entity.OmsOrderOperateHistory;
import com.macro.mall.tiny.modules.oms.service.OmsOrderOperateHistoryService;
import org.springframework.stereotype.Service;

/**
 * 订单操作历史记录(OmsOrderOperateHistory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:53
 */
@Service("omsOrderOperateHistoryService")
public class OmsOrderOperateHistoryServiceImpl extends ServiceImpl<OmsOrderOperateHistoryDao, OmsOrderOperateHistory> implements OmsOrderOperateHistoryService {

}
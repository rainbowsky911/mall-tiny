package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductVertifyRecordDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductVertifyRecord;
import com.macro.mall.tiny.modules.pms.service.PmsProductVertifyRecordService;
import org.springframework.stereotype.Service;

/**
 * 商品审核记录(PmsProductVertifyRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:35
 */
@Service("pmsProductVertifyRecordService")
public class PmsProductVertifyRecordServiceImpl extends ServiceImpl<PmsProductVertifyRecordDao, PmsProductVertifyRecord> implements PmsProductVertifyRecordService {

}
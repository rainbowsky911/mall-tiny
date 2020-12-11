package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsMemberReportDao;
import com.macro.mall.tiny.modules.cms.entity.CmsMemberReport;
import com.macro.mall.tiny.modules.cms.service.CmsMemberReportService;
import org.springframework.stereotype.Service;

/**
 * 用户举报表(CmsMemberReport)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@Service("cmsMemberReportService")
public class CmsMemberReportServiceImpl extends ServiceImpl<CmsMemberReportDao, CmsMemberReport> implements CmsMemberReportService {

}
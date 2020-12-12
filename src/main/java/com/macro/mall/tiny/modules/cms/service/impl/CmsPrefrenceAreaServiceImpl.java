package com.macro.mall.tiny.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cms.dao.CmsPrefrenceAreaDao;
import com.macro.mall.tiny.modules.cms.entity.CmsPrefrenceArea;
import com.macro.mall.tiny.modules.cms.service.CmsPrefrenceAreaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优选专区(CmsPrefrenceArea)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:20:14
 */
@Service("cmsPrefrenceAreaService")
public class CmsPrefrenceAreaServiceImpl extends ServiceImpl<CmsPrefrenceAreaDao, CmsPrefrenceArea> implements CmsPrefrenceAreaService {

    @Override
    public List<CmsPrefrenceArea> getCmsPrefrenceAreaList() {
        return list();
    }
}
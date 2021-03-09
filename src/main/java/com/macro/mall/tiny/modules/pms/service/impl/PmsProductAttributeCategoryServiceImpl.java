package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductAttributeCategoryDao;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttributeCategory;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeCategoryService;
import com.macro.mall.tiny.modules.ums.dto.PmsProductAttributeCategoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品属性分类表(PmsProductAttributeCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:32
 */
@Service("pmsProductAttributeCategoryService")
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryDao, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {


    @Autowired
    private PmsProductAttributeCategoryDao pmsProductAttributeCategoryDao;

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return pmsProductAttributeCategoryDao.getListWithAttr();
    }

    @Override
    public Page<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        Page<PmsProductAttributeCategory> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProductAttributeCategory> wrapper = new QueryWrapper<>();
        return page(page, wrapper);
    }

    @Override
    public int update(Long id, String name) {
        boolean update = false;
        if (ObjectUtil.isNotNull(id)) {
            update = update(new LambdaUpdateWrapper<PmsProductAttributeCategory>()
                    .set(PmsProductAttributeCategory::getName, name)
                    .eq(PmsProductAttributeCategory::getId, id));
        }
        if (update) {
            return 1;
        } else {

            return 0;
        }
    }

}
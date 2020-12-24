package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsProductCategoryDao;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryService;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品分类(PmsProductCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
@Service("pmsProductCategoryService")
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryDao, PmsProductCategory> implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Override
    public Page<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        Page<PmsProductCategory> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProductCategory> lambda = wrapper.lambda();
        if (ObjectUtil.isNotNull(parentId)) {
            lambda.eq(PmsProductCategory::getParentId, parentId);
        }
        return page(page, wrapper);
    }

    @Override
    public int updateNavStatus(Long ids, Integer navStatus) {
        LambdaUpdateWrapper<PmsProductCategory> lambda = new LambdaUpdateWrapper<>();
        lambda.set(PmsProductCategory::getNavStatus, navStatus.byteValue());
        lambda.eq(PmsProductCategory::getId, ids);
        boolean update = update(lambda);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateShowStatus(Long ids, Integer showStatus) {
        LambdaUpdateWrapper<PmsProductCategory> lambda = new LambdaUpdateWrapper<>();
        lambda.set(PmsProductCategory::getNavStatus, showStatus.byteValue());
        lambda.eq(PmsProductCategory::getId, ids);
        boolean update = update(lambda);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> getCategoryListWithChild() {
        return productCategoryDao.getCategoryListWithChild();
    }
}
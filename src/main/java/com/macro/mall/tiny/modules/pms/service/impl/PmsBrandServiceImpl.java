package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsBrandDao;
import com.macro.mall.tiny.modules.pms.dao.PmsProductDao;
import com.macro.mall.tiny.modules.pms.dto.PmsBrandParam;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import com.macro.mall.tiny.modules.pms.service.PmsBrandService;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌表(PmsBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@Service("pmsBrandService")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrand> implements PmsBrandService {

    @Autowired
    private PmsBrandDao pmsBrandDao;

    @Autowired
    private PmsProductService pmsProductService;

    @Override
    public Page<PmsBrand> getList(Integer pageSize, Integer pageNum) {
        Page<PmsBrand> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        return page(page, wrapper);
    }

    @Override
    public int updateFactoryStatus(Long ids, Integer factoryStatus) {
        LambdaUpdateWrapper<PmsBrand> lambdaUpdate = new LambdaUpdateWrapper();
        lambdaUpdate.set(PmsBrand::getFactoryStatus, factoryStatus);
        lambdaUpdate.eq(PmsBrand::getId, ids);
        boolean update = update(lambdaUpdate);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateShowStatus(Long ids, Integer showStatus) {
        LambdaUpdateWrapper<PmsBrand> lambdaUpdate = new LambdaUpdateWrapper();
        lambdaUpdate.set(PmsBrand::getShowStatus, showStatus);
        lambdaUpdate.eq(PmsBrand::getId, ids);
        boolean update = update(lambdaUpdate);
        if (update) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        boolean pmsBrandStatus = updateById(pmsBrand);
        boolean productStatus = pmsProductService.update(new UpdateWrapper<PmsProduct>().lambda()
                .set(PmsProduct::getBrandName, pmsBrand.getName())
                .eq(PmsProduct::getBrandId, id));
        if (pmsBrandStatus && productStatus) {
            return 1;
        } else {

            return 0;
        }
    }
}
package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.dto.PmsBrandParam;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌表(PmsBrand)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
public interface PmsBrandService extends IService<PmsBrand> {


    /**
     * 查询所有商品品牌分类
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<PmsBrand> getList(Integer pageSize, Integer pageNum);


    /**
     * 修改品牌制造商状态
     *
     * @param ids
     * @param factoryStatus
     * @return
     */
    int updateFactoryStatus(Long ids, Integer factoryStatus);


    /**
     * 修改显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    int updateShowStatus(Long ids, Integer showStatus);

    /**
     * 修改品牌信息
     *
     * @param pmsBrandParam
     * @return
     */
    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);
}
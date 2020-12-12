package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.dto.PmsProductParam;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品信息(PmsProduct)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
public interface PmsProductService extends IService<PmsProduct> {



    /**
     * 创建商品信息
     * @param pmsProductParam
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam pmsProductParam);


    /**
     * 分页获取商品列表
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<PmsProduct> getList(Integer pageSize, Integer pageNum);

    /**
     * 修改出版状态
     * @param ids
     * @param publishStatus
     * @return
     */
    int updatePublishStatus(Long ids, Integer publishStatus);

    /**修改修改状态
     * @param ids
     * @param newStatus
     * @return
     */
    int updateNewStatus(Long ids, Integer newStatus);

    /**
     * 修改推荐状态
     * @param ids
     * @param recommendStatus
     * @return
     */
    int updateRecommendStatus(Long ids, Integer recommendStatus);
}
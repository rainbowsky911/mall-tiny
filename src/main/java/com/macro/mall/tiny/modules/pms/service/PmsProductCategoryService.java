package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.modules.pms.entity.PmsProductCategory;

import java.util.List;

/**
 * 产品分类(PmsProductCategory)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 13:40:33
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {


    /**
     * 分类
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<PmsProductCategory> getList(Long  parentId,Integer  pageSize,Integer  pageNum);


    /**修改导航
     * @param ids
     * @param navStatus
     * @return
     */
    int  updateNavStatus(Long ids, Integer navStatus);


    int updateShowStatus(Long ids, Integer showStatus);

    /**
     * 获取分类及其子分类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> getCategoryListWithChild();
}
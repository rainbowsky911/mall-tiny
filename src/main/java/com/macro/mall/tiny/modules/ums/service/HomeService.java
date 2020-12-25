package com.macro.mall.tiny.modules.ums.service;

import com.macro.mall.tiny.modules.cms.entity.CmsSubject;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.ums.entity.HomeContentResult;

import java.util.List;

public interface HomeService {


    /**
     * 首页内容管理
     *
     * @return
     */
    public HomeContentResult content();

    /**分页获取人气推荐商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> newProductList(Integer pageSize, Integer pageNum);

    /**分页获取推荐商品
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 根据分类获取专题
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<CmsSubject> subjectList(Integer pageSize, Integer pageNum);
}

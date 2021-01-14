package com.macro.mall.tiny.modules.pms.service;

import com.macro.mall.tiny.modules.pms.domain.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 搜索商品管理接口
 */
public interface EsProductService {


    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * 根据ID删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据ID创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);


    /**ES根据关键字简单查询
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}

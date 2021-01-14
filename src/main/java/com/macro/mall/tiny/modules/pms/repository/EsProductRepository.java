package com.macro.mall.tiny.modules.pms.repository;

import com.macro.mall.tiny.modules.pms.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {


    /**
     * 根据名称或者标题或者关键字分页查询
     * @param keyword
     * @param keyword1
     * @param keyword2
     * @param pageable
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String keyword, String keyword1, String keyword2, Pageable pageable);
}

package com.macro.mall.tiny.modules.pms.repository;

import com.macro.mall.tiny.modules.pms.domain.EsProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
}

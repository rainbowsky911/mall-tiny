package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.macro.mall.tiny.modules.pms.dao.EsProductDao;
import com.macro.mall.tiny.modules.pms.domain.EsProduct;
import com.macro.mall.tiny.modules.pms.repository.EsProductRepository;
import com.macro.mall.tiny.modules.pms.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {


    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<EsProduct>();
            ids.forEach(e -> {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(e);
                esProductList.add(esProduct);
            });
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> productList = productDao.getAllEsProductList(id);
        if (productList.size() > 0) {
            EsProduct esProduct = productList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}

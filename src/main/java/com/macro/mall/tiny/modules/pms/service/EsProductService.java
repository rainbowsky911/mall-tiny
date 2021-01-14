package com.macro.mall.tiny.modules.pms.service;

/**
 * 搜索商品管理接口
 */
public interface EsProductService {


    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

}

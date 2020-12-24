package com.macro.mall.tiny.modules.oms.dao;

import com.macro.mall.tiny.modules.oms.dto.PromotionProduct;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台商品自定义Dao
 * @author 51473
 */
public interface PortalProductDao {


    /**
     * 获取促销商品列表
     * @param ids
     * @return
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);


    List<PmsProduct> listPromotionProductList();
}

package com.macro.mall.tiny.modules.ums.dao;

import com.macro.mall.tiny.modules.cms.entity.CmsSubject;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.ums.entity.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * * 首页内容管理自定义Dao
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 获得新品推荐
     *
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 人气推荐
     *
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获得专题推荐
     *
     * @param offset
     * @param limit
     * @return
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     *
     * @return
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

}

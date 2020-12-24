package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.oms.dao.PortalProductDao;
import com.macro.mall.tiny.modules.oms.dto.PromotionProduct;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsPromotionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PmsPromotionProductTest extends MallTinyApplicationTests {

    @Autowired
    private PortalProductDao portalProductDao;


    @Test
    public void testGetRecommendBrandList() {
        List<PromotionProduct> list = portalProductDao.getPromotionProductList(Arrays.asList(28L));
        list.stream().forEach(e -> {
            System.out.println(e);
        });

       /* portalProductDao.listPromotionProductList().stream()
        .forEach(e->{
            System.out.println(e);
        });*/
    }

    @Autowired
    private OmsPromotionService omsPromotionService;

    @Test
    public void testCartItem() {
        OmsCartItem item1 = new OmsCartItem()
                .setId(12L)
                .setProductSkuId(110L)
                .setProductCategoryId(19L)
                .setMemberId(1L)
                .setMemberNickname("jack")
                .setProductId(26L)
                .setProductCategoryId(19L)
                .setQuantity(1)
                .setProductSkuCode("201806070026001")
                .setDeleteStatus(0)
                .setPrice(3788.00)
                .setProductBrand("华为 HUAWEI P20");

        OmsCartItem item2 = new OmsCartItem()
                .setId(13L)
                .setProductSkuId(111L)
                .setProductId(1L)
                .setMemberId(1L)
                .setMemberNickname("jack")
                .setProductCategoryId(19L)
                .setProductId(27L)
                .setProductCategoryId(19L)
                .setQuantity(3)
                .setProductSkuCode("201808270027001")
                .setDeleteStatus(0)
                .setPrice(2699.00)
                .setProductBrand("骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购");

        OmsCartItem item3 = new OmsCartItem()
                .setId(14L)
                .setProductSkuId(112L)
                .setProductCategoryId(19L)
                .setProductId(1L)
                .setMemberId(1L)
                .setMemberNickname("jack")
                .setProductId(28L)
                .setProductCategoryId(19L)
                .setQuantity(1)
                .setProductSkuCode("201808270028001")
                .setDeleteStatus(0)
                .setPrice(649.00)
                .setProductBrand("8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购");

        OmsCartItem item4 = new OmsCartItem()
                .setId(15L)
                .setProductSkuId(103L)
                .setProductCategoryId(19L)
                .setMemberId(1L)
                .setMemberNickname("jack")
                .setProductId(28L)
                .setProductCategoryId(19L)
                .setQuantity(1)
                .setProductSkuCode("201808270028001")
                .setDeleteStatus(0)
                .setPrice(649.00)
                .setProductBrand("8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购");

        List<OmsCartItem> cartItemList = new ArrayList<>(Arrays.asList
                (item4));
        omsPromotionService.calcCartPromotion(cartItemList);
    }

}

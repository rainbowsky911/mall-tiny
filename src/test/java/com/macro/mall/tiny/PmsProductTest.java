package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.pms.dao.PmsMemberPriceDao;
import com.macro.mall.tiny.modules.pms.entity.PmsMemberPrice;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.pms.service.PmsProductCategoryService;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PmsProductTest extends MallTinyApplicationTests {

    @Autowired
    private PmsProductCategoryService productCategoryService;

    @Autowired
    private PmsProductService productService;

    @Autowired
    private PmsMemberPriceDao pmsMemberPriceDao;

    /**
     * 查询分类及其子分类
     */
    @Test
    public void testListCategoryWithChild() {
        productCategoryService.getCategoryListWithChild().forEach(System.out::println);
    }

    @Test
    public void testBatchInsertMemberPrice() {
        List<PmsMemberPrice> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PmsMemberPrice memberPrice = new PmsMemberPrice();
            //  memberPrice.setProductId(1L);
            memberPrice.setMemberLevelId((long) (i + 1));
            memberPrice.setMemberPrice(new BigDecimal("22").doubleValue());
            list.add(memberPrice);
        }
        int count = pmsMemberPriceDao.insertList(list);
        Assert.assertEquals(5, count);
    }


    @Test
    public  void testList(){
        for (PmsProduct e : productService.getList(1, 10).getRecords()) {
            System.out.println(e);
        }
    }



}

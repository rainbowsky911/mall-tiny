package com.macro.mall.tiny;


import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeCategoryService;
import com.macro.mall.tiny.modules.ums.dto.PmsProductAttributeCategoryItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsProductAttributeCategoryServiceTest {


    @Autowired
    private PmsProductAttributeCategoryService productCategoryService;


    @Test
    public void getListWithAttr() {
        List<PmsProductAttributeCategoryItem> listWithAttr = productCategoryService.getListWithAttr();

        listWithAttr.stream().forEach(e->{
            System.out.println(e);
        });
    }
}

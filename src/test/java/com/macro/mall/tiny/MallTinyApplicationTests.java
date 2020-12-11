package com.macro.mall.tiny;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.macro.mall.tiny.modules.pms.dto.ProductAttrInfo;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.entity.PmsProductAttribute;
import com.macro.mall.tiny.modules.pms.service.PmsProductAttributeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallTinyApplicationTests {

    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;

    @Test
    public void contextLoads() {

        List<ProductAttrInfo> info = pmsProductAttributeService.getProductAttrInfo(24L);

        info.forEach(e->{
            System.out.println(e);
        });
    }



}

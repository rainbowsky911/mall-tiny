package com.macro.mall.tiny;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.macro.mall.tiny.modules.pms.entity.PmsBrand;
import com.macro.mall.tiny.modules.pms.service.PmsBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsbrandTest {

    @Autowired
    private PmsBrandService pmsBrandService;

    @Test
    public void testUpdateBrand() {
        LambdaUpdateWrapper<PmsBrand> lambdaUpdate = new LambdaUpdateWrapper();
        lambdaUpdate.set(PmsBrand::getFactoryStatus, 0);
        lambdaUpdate.eq(PmsBrand::getId, 1);
        boolean update = pmsBrandService.update(lambdaUpdate);
        if (update) {
            System.out.println("succ");
        } else {
            System.out.println("fail");
        }

    }


}

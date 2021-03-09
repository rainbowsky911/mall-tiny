package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.oms.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.modules.oms.service.OmsOrderReturnApplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OmsOrderReturnApplyServiceTest {

    @Autowired
    OmsOrderReturnApplyService orderApplyService;

    @Test
    public void test(){
        OmsOrderReturnApplyResult item = orderApplyService.getItem(3L);
        System.out.println(item.toString());
    }
}

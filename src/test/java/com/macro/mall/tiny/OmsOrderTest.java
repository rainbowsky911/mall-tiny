package com.macro.mall.tiny;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.oms.dto.OmsOrderQueryParam;
import com.macro.mall.tiny.modules.oms.service.OmsOrderService;
import org.junit.Test;

import javax.annotation.Resource;

public class OmsOrderTest extends  MallTinyApplicationTests {


    @Resource
    private OmsOrderService omsOrderService;

    @Test
    public  void testOrderList(){
        omsOrderService.getList(new Page(0,10),new OmsOrderQueryParam().setStatus(1)).getRecords().stream().forEach(e->{
            System.out.println(e);
        });
    }
}

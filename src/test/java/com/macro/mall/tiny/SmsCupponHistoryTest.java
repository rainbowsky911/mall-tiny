package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.sms.dao.SmsCouponHistoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsCupponHistoryTest  extends  MallTinyApplicationTests{

    @Autowired
    private SmsCouponHistoryDao smsCouponHistoryDao;

    @Test
    public  void test_smscupponTest(){
        smsCouponHistoryDao.getDetailList(1L).stream().forEach(e->{
            System.out.println(e);
        });
    }
}

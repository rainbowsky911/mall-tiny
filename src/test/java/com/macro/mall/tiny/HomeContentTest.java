package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.ums.dao.HomeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeContentTest {

    @Autowired
    private HomeDao homeDao;

    @Test
    public void test_homeContent() {
        homeDao.getRecommendBrandList(0, 10).stream().forEach(e -> {
            System.out.println(e);
        });
    }
}

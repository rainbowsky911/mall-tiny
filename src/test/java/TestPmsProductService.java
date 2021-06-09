import com.macro.mall.tiny.MallTinyApplication;
import com.macro.mall.tiny.modules.pms.dto.TestPmsProductParam;
import com.macro.mall.tiny.modules.pms.service.PmsProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: zdw
 * @Date: 2021/06/10/2:16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallTinyApplication.class)
public class TestPmsProductService {

    @Autowired
    private PmsProductService productService;


    /**
     * 测试mybatis一对多查询。  ID对应价格表
     */
    @Test
    public  void test1(){
        TestPmsProductParam param = productService.getUpdateinfo(10L);
        System.out.println(param);
    }
}

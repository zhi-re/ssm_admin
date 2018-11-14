import fun.chenqi.domain.Product;
import fun.chenqi.service.IProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {
    @Test
    public void test01() throws Exception {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-service.xml");
        IProductService service = app.getBean(IProductService.class);
        List<Product> list = service.findAll();
        for (Product product : list) {
            System.out.println(product);

        }

    }
}

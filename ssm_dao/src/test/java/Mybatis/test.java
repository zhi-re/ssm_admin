package Mybatis;

import fun.chenqi.dao.OrderDao;
import fun.chenqi.dao.ProductDao;
import fun.chenqi.dao.SysDao;
import fun.chenqi.domain.Order;
import fun.chenqi.domain.Product;
import fun.chenqi.domain.SysUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test01() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        SysDao dao = app.getBean(SysDao.class);
        SysUser user = dao.fundByName("chenqi");
        System.out.println(user);

    }
}

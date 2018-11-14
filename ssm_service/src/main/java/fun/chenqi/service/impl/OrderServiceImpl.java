package fun.chenqi.service.impl;

import fun.chenqi.dao.OrderDao;
import fun.chenqi.dao.ProductDao;
import fun.chenqi.domain.Order;
import fun.chenqi.domain.Product;
import fun.chenqi.service.IOrderService;
import fun.chenqi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderDao dao;

    // 查询所有订单
    public List<Order> findAllOrder() throws Exception {
        //System.out.println(dao.findAllOrder());
        return dao.findAllOrder();
    }
}

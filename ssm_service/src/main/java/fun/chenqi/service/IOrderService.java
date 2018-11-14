package fun.chenqi.service;

import fun.chenqi.domain.Order;
import fun.chenqi.domain.Product;

import java.util.List;

public interface IOrderService {

    List<Order> findAllOrder() throws Exception;


}

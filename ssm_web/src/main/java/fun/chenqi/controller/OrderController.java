package fun.chenqi.controller;

import fun.chenqi.domain.Order;
import fun.chenqi.domain.Product;
import fun.chenqi.service.IOrderService;
import fun.chenqi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService service;

    // 查询所有旅游路线
    @RequestMapping("/findAllOrder")
    public String findAllOrder(Model model) throws Exception {
        List<Order> list = service.findAllOrder();
        model.addAttribute("orderList", list);
        return "order-list";
    }


}

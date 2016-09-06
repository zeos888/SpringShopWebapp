package org.spring.controller;

import org.spring.dao.OrderDao;
import org.spring.dao.impl.OrderDaoImpl;
import org.spring.entity.Order;
import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by alxev on 04.09.2016.
 */
@Controller
public class OrderController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/a")
    public String test(Model model){
        System.out.println("------------------------------------------>");
        return "orderView";
    }



    @RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
    public String viewOrder(int orderId, Model model){
        Order order = shopService.findOrderById(orderId);
        model.asMap().put("order", order);
        return "orderView";
    }

    @RequestMapping(value = "/viewAllOrders", method = RequestMethod.GET)
    public String viewAllOrders(Model model){
        List<Order> orders = shopService.findAllOrders();
        model.addAttribute("orders", orders);
        return "ordersView";
    }

}

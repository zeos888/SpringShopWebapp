package org.spring.controller;

import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ovoyevodin on 06.09.2016.
 */
@Controller
@RequestMapping("/")
public class ShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public String viewMainPage(Model model){
        model.addAttribute("categories", shopService.findAllProductCategories());
        model.addAttribute("products", shopService.findAllProducts());
        model.addAttribute("customers", shopService.findAllCustomers());
        model.addAttribute("orders", shopService.findAllOrders());
        return "orderPage";
    }
}

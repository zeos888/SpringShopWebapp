package org.spring.controller;

import org.spring.entity.*;
import org.spring.exception.NotEnoughException;
import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alxev on 07.09.2016.
 */
@Controller
@RequestMapping("/")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(ProductCategory.class, new ProductCategoryEditor());
    }

    @RequestMapping(value = "/newProduct/", method = RequestMethod.GET)
    public String newProduct(Model model){
        model.addAttribute("newProduct", new Product());
        model.addAttribute("categories", shopService.findAllProductCategories());
        return "newProduct";
    }

    @RequestMapping(value = "/addProduct/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product product, @ModelAttribute("productCategory")ProductCategory productCategory, ModelMap modelMap){
//        product.setProductCategory(shopService.getCategoryById(productCategoryId));
        product.setProductCategory(productCategory);
        shopService.addOrReplaceProduct(product);
        modelMap.addAttribute("products", shopService.findAllProductsByCategoryId(product.getProductCategory().getId()));
        modelMap.addAttribute("categoryName", shopService.getCategoryName(product));
        modelMap.addAttribute("productName", product.getName());
        return "addedProduct";
    }

    @RequestMapping(value = "/newProductCategory/", method = RequestMethod.GET)
    public String newProductCategory(Model model){
        model.addAttribute("newProductCategory", new ProductCategory());
        return "newProductCategory";
    }

    @RequestMapping(value = "/addProductCategory/", method = RequestMethod.POST)
    public String addProductCategory(@ModelAttribute("root")ProductCategory productCategory, ModelMap modelMap){
        shopService.addProductCategory(productCategory);
        modelMap.addAttribute("productCategories", shopService.findAllProductCategories());
        modelMap.addAttribute("categoryName", productCategory.getName());
        return "addedProductCategory";
    }

    @RequestMapping(value = "/newCustomer/", method = RequestMethod.GET)
    public String newCustomer(Model model){
        model.addAttribute("newCustomer", new Customer());
        return "newCustomer";
    }

    @RequestMapping(value = "/addCustomer/", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("root")Customer customer, ModelMap modelMap){
        shopService.addOrReplaceCustomer(customer);
        modelMap.addAttribute("customerName", customer.getName());
        modelMap.addAttribute("customers", shopService.findAllCustomers());
        return "addedCustomer";
    }

    @RequestMapping(value = "/newOrder/", method = RequestMethod.GET)
    public String newOrder(Model model){
        model.addAttribute("newOrder", new Order());
        model.addAttribute("customers", shopService.findAllCustomers());
        model.addAttribute("products", shopService.findAllProducts());
        return "newOrder";
    }

    @RequestMapping(value = "/addOrder/", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("root")Order order, @ModelAttribute("root")Product product, @ModelAttribute("root")Customer customer, ModelMap modelMap){
        try {
            shopService.placeOrder(customer, product, order.getQuantity());
        } catch (NotEnoughException e){
            modelMap.addAttribute("productName", product.getName());
            modelMap.addAttribute("orderQuantity", order.getQuantity());
            modelMap.addAttribute("productQuantity", product.getQuantity());
            return "failedOrder";
        }
        modelMap.addAttribute("ordersByCustomer", shopService.findAllOrdersByCustomerId(customer.getId()));
        modelMap.addAttribute("customerName", customer.getName());
        modelMap.addAttribute("productName", product.getName());
        modelMap.addAttribute("quantity", order.getQuantity());
        return "addedOrder";
    }
}

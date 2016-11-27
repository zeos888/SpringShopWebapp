package org.spring.controller;

import org.spring.bean.OrderBean;
import org.spring.bean.ProductBean;
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
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/newProduct/")
    public ModelAndView newProduct(){
        ProductBean product = new ProductBean();
        ModelAndView result = new ModelAndView("newProduct");
        result.addObject("newProduct", product);
        result.addObject("categories", shopService.findAllProductCategories());
        return result;
    }

    @RequestMapping("/addProduct/")
    public ModelAndView addProduct(ProductBean product){
        Product p = new Product();
        p.setDescription(product.getDescription());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
        p.setProductCategory(shopService.getCategoryById(product.getProductCategoryId()));
        shopService.addOrReplaceProduct(p);
        ModelAndView result = new ModelAndView("addedProduct");
        result.addObject("products", shopService.findAllProductsByCategoryId(product.getProductCategoryId()));
        result.addObject("categoryName", shopService.getCategoryName(p));
        result.addObject("productName", product.getName());
        return result;
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

    @RequestMapping("/newOrder/")
    public ModelAndView newOrder(){
        OrderBean order = new OrderBean();
        ModelAndView result = new ModelAndView("newOrder");
        result.addObject("newOrder", order);
        result.addObject("customers", shopService.findAllCustomers());
        result.addObject("products", shopService.findAllProducts());
        return result;
    }

    @RequestMapping("/addOrder/")
    public ModelAndView addOrder(OrderBean orderBean){

        try {
            shopService.placeOrder(shopService.getCustomerById(orderBean.getCustomerId()), shopService.getProductById(orderBean.getProductId()), orderBean.getQuantity());
        } catch (NotEnoughException e){
            ModelAndView result = new ModelAndView("failedOrder");
            result.addObject("productName", shopService.getProductById(orderBean.getProductId()).getName());
            result.addObject("orderQuantity", orderBean.getQuantity());
            result.addObject("productQuantity", shopService.getProductById(orderBean.getProductId()).getQuantity());
            return result;
        }
        ModelAndView result = new ModelAndView("addedOrder");
        result.addObject("ordersByCustomer", shopService.findAllOrdersByCustomerId(orderBean.getCustomerId()));
        result.addObject("customerName", shopService.getCustomerById(orderBean.getCustomerId()).getName());
        result.addObject("productName", shopService.getProductById(orderBean.getProductId()).getName());
        result.addObject("quantity", orderBean.getQuantity());
        return result;
    }
    /*
    @RequestMapping(value = "/newOrder/", method = RequestMethod.GET)
    public String newOrder(Model model){
        model.addAttribute("newOrder", new Order());
        model.addAttribute("customers", shopService.findAllCustomers());
        model.addAttribute("products", shopService.findAllProducts());
        return "newOrder";
    }
    */

    /*@RequestMapping(value = "/addOrder/", method = RequestMethod.POST)
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
    }*/
}

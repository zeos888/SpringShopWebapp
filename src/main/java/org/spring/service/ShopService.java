package org.spring.service;

import org.spring.entity.Customer;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.entity.ProductCategory;
import org.spring.exception.NotEnoughException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alxev on 04.09.2016.
 */
public interface ShopService {
    List<ProductCategory> findAllProductCategories();
    void addProductCategory(ProductCategory productCategory);
    ProductCategory getCategoryById(int id);

    List<Product> findAllProducts();
    List<Product> findAllProductsByCategoryId(int categoryId);
    void addOrReplaceProduct(Product product);
    String getCategoryName(Product product);
    Product getProductById(int id);

    List<Customer> findAllCustomers();
    void addOrReplaceCustomer(Customer customer);
    Customer getCustomerById(int id);

    void placeOrder(Customer customer, Product product, int quantity) throws NotEnoughException;
    List<Order> findAllOrders();
    List<Order> findAllOrdersByCustomerId(int customerId);
    List<Order> findAllOrdersByProductId(int productId);
    Product getProduct(Order order);
    Customer getCustomer(Order order);
    Order findOrderById(int id);
}

package org.spring.service.impl;

import org.spring.dao.CustomerDao;
import org.spring.dao.OrderDao;
import org.spring.dao.ProductCategoryDao;
import org.spring.dao.ProductDao;
import org.spring.entity.Customer;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.entity.ProductCategory;
import org.spring.exception.NotEnoughException;
import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alxev on 04.09.2016.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;

    public List<ProductCategory> findAllProductCategories() {
        return productCategoryDao.getAll();
    }

    public void addProductCategory(ProductCategory productCategory) {
        productCategoryDao.insert(productCategory);
    }

    public List<Product> findAllProducts() {
        return productDao.getAll();
    }

    public List<Product> findAllProductsByCategoryId(int categoryId) {
        return productDao.getByCategory(productCategoryDao.getById(categoryId));
    }

    public void addOrReplaceProduct(Product product) {
        productDao.insert(product);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.getAll();
    }

    public void addOrReplaceCustomer(Customer customer) {
        customerDao.insert(customer);
    }

    public void placeOrder(Customer customer, Product product, int quantity) throws NotEnoughException{
        orderDao.placeNewOrder(customer, product, quantity);
    }

    public Order findOrderById(int id) {
        return orderDao.getById(id);
    }

    public Customer getCustomer(Order order) {
        return order.getCustomer();
    }

    public Product getProduct(Order order) {
        return order.getProduct();
    }

    public ProductCategory getCategoryById(int id) {
        return productCategoryDao.getById(id);
    }

    public String getCategoryName(Product product) {
        return product.getProductCategory().getName();
    }

    public List<Order> findAllOrders() {
        return orderDao.getAll();
    }

    public List<Order> findAllOrdersByCustomerId(int customerId) {
        return orderDao.getByCustomer(customerDao.getById(customerId));
    }

    public List<Order> findAllOrdersByProductId(int productId) {
        return orderDao.getByProduct(productDao.getById(productId));
    }
}

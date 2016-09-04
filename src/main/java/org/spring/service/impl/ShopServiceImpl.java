package org.spring.service.impl;

import org.spring.dao.OrderDao;
import org.spring.dao.ProductDao;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alxev on 04.09.2016.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    private OrderDao orderDao;
    private ProductDao productDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Order> findAllOrders() {
        return orderDao.getAll();
    }

    public Order findOrderById(int id) {
        return orderDao.getById(id);
    }

    public List<Product> findAllProducts() {
        return productDao.getAll();
    }
}
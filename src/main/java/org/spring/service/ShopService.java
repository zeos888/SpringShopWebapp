package org.spring.service;

import org.spring.entity.Order;
import org.spring.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alxev on 04.09.2016.
 */
public interface ShopService {
    List<Order> findAllOrders();
    Order findOrderById(int id);
    List<Product> findAllProducts();
}

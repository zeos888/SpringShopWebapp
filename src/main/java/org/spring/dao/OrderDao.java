package org.spring.dao;

import org.spring.entity.Customer;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.exception.NotEnoughException;

import java.util.Date;
import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
public interface OrderDao {
    Order getById(int id);
    List<Order> getAll();
    List<Order> getByDatePeriod(Date dateFrom, Date dateTo);
    List<Order> getByCustomer(Customer customer);
    List<Order> getByProduct(Product product);
    void placeNewOrder(Customer customer, Product product, int quantity) throws NotEnoughException;
    void placeNewOrder(int customerId, int productId, int quantity) throws NotEnoughException;
}

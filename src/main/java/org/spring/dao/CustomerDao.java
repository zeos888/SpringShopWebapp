package org.spring.dao;

import org.spring.entity.Customer;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
public interface CustomerDao {
    Customer getById(int id);
    List<Customer> getAll();
    void insert(Customer customer);
    Customer getByName(String name);
}

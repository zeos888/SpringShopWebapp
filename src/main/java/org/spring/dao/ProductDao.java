package org.spring.dao;

import org.spring.entity.Product;
import org.spring.entity.ProductCategory;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
public interface ProductDao {
    Product getById(int id);
    void insert(Product product);
    List<Product> getAll();
    List<Product> getByCategory(ProductCategory productCategory);
}

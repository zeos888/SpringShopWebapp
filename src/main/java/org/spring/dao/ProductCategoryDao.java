package org.spring.dao;

import org.spring.entity.ProductCategory;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
public interface ProductCategoryDao {
    ProductCategory getById(int id);
    void insert(ProductCategory productCategory);
    List<ProductCategory> getAll();
}

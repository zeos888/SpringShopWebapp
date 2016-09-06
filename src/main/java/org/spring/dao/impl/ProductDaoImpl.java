package org.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.dao.ProductDao;
import org.spring.entity.Product;
import org.spring.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Product getById(int id) {
        return session.get(Product.class, id);
    }

    public void insert(Product product) {
        session.saveOrUpdate(product);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        return (List<Product>) session.createQuery("from Product").list();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getByCategory(ProductCategory productCategory) {
        return (List<Product>)session.createQuery("from Product where categoryId=?")
                .setParameter(0, productCategory.getId()).list();
    }

    public void insert(String name, String description, int productCategoryId, double price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setProductCategoryId(productCategoryId);
        product.setPrice(price);
        product.setQuantity(quantity);
        insert(product);
    }
}

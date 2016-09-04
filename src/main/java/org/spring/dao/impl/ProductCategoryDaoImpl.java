package org.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.dao.ProductCategoryDao;
import org.spring.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public ProductCategory getById(int id) {
        return session.get(ProductCategory.class, id);
    }

    public void insert(ProductCategory productCategory) {
        session.saveOrUpdate(productCategory);
    }

    public List<ProductCategory> getAll() {
        return (List<ProductCategory>) session.createQuery("from ProductCategory").list();
    }
}

package org.spring.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.spring.dao.ProductCategoryDao;
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
    private ProductCategoryDao productCategoryDao;

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
        //return (List<Product>)session.createQuery("from Product where productCategoryId=?").setParameter(0, productCategory.getId()).list();
        Criteria c = session.createCriteria(Product.class);
        c.add(Restrictions.eq("productCategory", productCategory));
        return c.list();
        //return (List<Product>)session.createQuery("select p from product p where productCategoryId= :productCayegoryId").setParameter("productCayegoryId", productCategory.getId()).list();
    }
}

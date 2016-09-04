package org.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.dao.CustomerDao;
import org.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Customer getById(int id) {
        return session.get(Customer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getAll() {
        return (List<Customer>)session.createQuery("from Customer").list();
    }

    public void insert(Customer customer) {
        session.saveOrUpdate(customer);
    }

    @SuppressWarnings("unchecked")
    public Customer getByName(String name) {
        return (Customer)session.createQuery("from Customer where name=?").setParameter(0, name).uniqueResult();
    }
}

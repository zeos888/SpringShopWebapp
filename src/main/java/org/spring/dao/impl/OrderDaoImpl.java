package org.spring.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.spring.dao.CustomerDao;
import org.spring.dao.OrderDao;
import org.spring.dao.ProductDao;
import org.spring.entity.Customer;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.exception.NotEnoughException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by alxev on 03.09.2016.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }


    public Order getById(int id) {
        return session.get(Order.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        return (List<Order>)session.createQuery("from Order").list();
    }

    @SuppressWarnings("unchecked")
    public List<Order> getByDatePeriod(Date dateFrom, Date dateTo) {
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.ge("orderDate", dateFrom));
        criteria.add(Restrictions.le("orderDate", dateTo));
        return criteria.list();
        //return (List<Order>)session.createQuery("from Order where orderDate between ? and ?").setParameter(0, dateFrom).setParameter(1, dateTo).list();
    }

    @SuppressWarnings("unchecked")
    public List<Order> getByCustomer(Customer customer) {
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("customer", customer));
        return criteria.list();
        //return (List<Order>)session.createQuery("from Order where customerId=?").setParameter(0, customer.getId()).list();
    }

    public void placeNewOrder(Customer customer, Product product, int quantity) throws NotEnoughException {
        if (quantity > product.getQuantity()){
            throw new NotEnoughException();
        }
        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setOrderPrice(product.getPrice() * quantity);
        order.setQuantity(quantity);
        order.setOrderDate(new Date());
        product.setQuantity(product.getQuantity() - quantity);
        session.saveOrUpdate(order);
        session.saveOrUpdate(product);
    }

    public void placeNewOrder(int customerId, int productId, int quantity) throws NotEnoughException {
        placeNewOrder(customerDao.getById(customerId), productDao.getById(productId), quantity);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getByProduct(Product product) {
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("product", product));
        return criteria.list();
        //return (List<Order>)session.createQuery("from Order where productId=").setParameter(0, product.getId()).list();
    }
}

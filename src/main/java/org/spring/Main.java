package org.spring;

import org.spring.dao.CustomerDao;
import org.spring.dao.OrderDao;
import org.spring.dao.ProductCategoryDao;
import org.spring.dao.ProductDao;
import org.spring.entity.Customer;
import org.spring.entity.Order;
import org.spring.entity.Product;
import org.spring.entity.ProductCategory;
import org.spring.exception.NotEnoughException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alxev on 03.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDaoImpl");
        for (Customer c : customerDao.getAll()){
            System.out.println(c);
        }
        Customer customer = new Customer();
        customer.setEmail("w45ydrsthdf@shsdfgh");
        customer.setName("sdrtdr");
        customerDao.insert(customer);
        for (Customer c : customerDao.getAll()){
            System.out.println(c);
        }
        System.out.println(customerDao.getById(5));
        ProductCategoryDao productCategoryDao = (ProductCategoryDao) context.getBean("productCategoryDaoImpl");
        for (ProductCategory p : productCategoryDao.getAll()){
            System.out.println(p);
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("asdgfsths");
        productCategoryDao.insert(productCategory);
        for (ProductCategory p : productCategoryDao.getAll()){
            System.out.println(p);
        }

        ProductDao productDao = (ProductDao) context.getBean("productDaoImpl");
        Product p = new Product();
        p.setQuantity(2);
        p.setName("adgfasdf");
        p.setPrice(2.99);
        p.setDescription("atjdsthjdgh");
        productDao.insert(p);
        Product product = productDao.getById(1);
        //product.setQuantity(2);
        //productDao.insert(product);
        //productDao.insert(product);
        for (Product p1: productDao.getAll()){
            System.out.println(p1);
        }
        OrderDao orderDao = (OrderDao) context.getBean("orderDaoImpl");
        try {
            orderDao.placeNewOrder(customer, product, 2);
        } catch (NotEnoughException e){
            System.out.println("not enough");
        }

        for (Order o: orderDao.getAll()){
            System.out.println(o);
        }
        context.close();
    }
}

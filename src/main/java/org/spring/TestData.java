package org.spring;

import org.spring.dao.CustomerDao;
import org.spring.dao.OrderDao;
import org.spring.dao.ProductCategoryDao;
import org.spring.dao.ProductDao;
import org.spring.entity.Product;
import org.spring.entity.ProductCategory;
import org.spring.exception.NotEnoughException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ovoyevodin on 06.09.2016.
 */
public class TestData {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private ProductDao productDao;

    public void insertProduct(String name, String description, int productCategoryId, double price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setProductCategory(productCategoryDao.getById(productCategoryId));
        product.setPrice(price);
        product.setQuantity(quantity);
        productDao.insert(product);
    }

    public void insertProduct(String name, String description, ProductCategory productCategory, double price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setProductCategory(productCategory);
        product.setPrice(price);
        product.setQuantity(quantity);
        productDao.insert(product);
    }

    public void init(){
        // Adding some fake customers
        customerDao.insert("Oleksandr Bezyna", "OBezyna@luxoft.com");           //1
        customerDao.insert("Oleksandr Eryomenko", "AEryomenko@luxoft.com");     //2
        customerDao.insert("Ella Holovko", "EHolovko@luxoft.com");              //3
        customerDao.insert("Kseniia Orlenko", "KOrlenko@luxoft.com");          //4
        customerDao.insert("Oleh Yushchenko", "OSYushchenko@luxoft.com");      //5
        // Adding some fake categories
        productCategoryDao.insert("Books");     //1
        productCategoryDao.insert("Magazines"); //2
        productCategoryDao.insert("Souvenirs"); //3
        // Adding some fake products
        insertProduct("Thinking in Java (4th Edition)", "by Bruce Eckel", 1, 42.3, 10);                 //1
        insertProduct("Spring in Action", "by Craig Walls", 1, 47.49, 5);                               //2
        insertProduct("Java Power Tools", "by John Ferguson Smart", 1, 41.64, 3);                       //3

        insertProduct("Java Magazine", "Java Magazine is a bimonthly deep dive into Java", 2, 0, 99);   //4
        insertProduct("Oracle Magazine", "by Oracle", 2, 0, 99);                                        //5

        insertProduct("Luxoft t-shirt", "We do IT t-shirt", 3, 20, 11);                                 //6
        insertProduct("Luxoft cup", "White Luxoft cup", 3, 10, 40);                                     //7
        insertProduct("Luxoft paper notebook", "White Luxoft paper notebook", 3, 2, 100);               //8
        // Adding some fake orders
        try {
            orderDao.placeNewOrder(1, 2, 1);
            orderDao.placeNewOrder(2, 7, 2);
            orderDao.placeNewOrder(3, 1, 1);
            orderDao.placeNewOrder(4, 3, 2);
            orderDao.placeNewOrder(5, 5, 1);
            orderDao.placeNewOrder(2, 7, 3);
        } catch (NotEnoughException ignoreIt){
            System.out.println("Incorrect order discovered");
        }

    }
}

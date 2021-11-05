package ru.example.oop;

import ru.example.oop.first.dao.CustomerDao;
import ru.example.oop.first.dao.Dao;
import ru.example.oop.first.dao.OrderDao;
import ru.example.oop.first.dao.ProductDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductApplication {
    private static Dao<Product> productDao;
    public static void main(String[] args) {
       var prod = new ProductDao();
       var customer1 = new CustomerDao();
       var order = new OrderDao();

       var p1 = new Product(1,"name1", new BigDecimal(1), true, "desc1");
       var p2 = new Product(2,"name1", new BigDecimal(1), true, "desc1");
       var c1 = new Customer(1,"name1c", "111", "address", "pers");

       prod.save(p1);
       prod.save(p2);
       customer1.save(c1);
       order.save(new Order(List.of(p1), c1, new Date(), 1));

        System.out.println(prod.getCodes());

//        System.out.println(prod.getAll());
//        System.out.println(customer1.getAll());
//        System.out.println(order.getAll());
        //System.out.println(prod.getById(3));
    }
}

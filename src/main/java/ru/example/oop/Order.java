package ru.example.oop;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private long id;
    private List<Product> product;
    private Customer customer;
    private Date date;
    private Integer count;

    public Order(List<Product> product, Customer customer, Date date, Integer count) {
        this.product = product;
        this.customer = customer;
        this.date = date;
        this.count = count;
    }
}

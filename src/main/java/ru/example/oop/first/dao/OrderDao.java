package ru.example.oop.first.dao;

import ru.example.oop.Customer;
import ru.example.oop.Order;
import ru.example.oop.Product;
import ru.example.oop.first.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDao implements Dao<Order> {
    private final List<Order> orderList;
    private ProductDao productDao;
    private CustomerDao customerDao;

    public OrderDao() {
        orderList = new ArrayList<>();
    }

    @Override
    public Order getById(long id) throws NotFoundException {
        return orderList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Order with id=" + id + " not exist"));
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(Order order, String[] params) {

    }

    @Override
    public void delete(Order order) {
        orderList.remove(order);
    }

    public void clear(){
        orderList.clear();
    }

    public List<Long> getCodes(){
        return orderList.stream()
                .map(Order::getId)
                .collect(Collectors.toList());
    }

    private void appendProduct(Product product) {
        productDao.save(product);
    }

    private void appendCustomer(Customer customer) {
        customerDao.save(customer);
    }
}

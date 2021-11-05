package ru.example.oop.first.dao;

import ru.example.oop.Customer;
import ru.example.oop.Product;
import ru.example.oop.first.exception.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerDao implements Dao<Customer> {
    private final List<Customer> customerList;

    public CustomerDao(){
        customerList = new ArrayList<>();
    }

    @Override
    public Customer getById(long id) throws NotFoundException {
        return customerList.stream().filter(product -> product.getId() == id).findFirst()
                .orElseThrow(()-> new NotFoundException("Customer with id=" + id + " not exist"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(Customer customer, String[] params) {
        customer.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        customer.setPhone(Objects.requireNonNull(
                params[1], "Phone cannot be null"));
        customer.setAddress(Objects.requireNonNull(
                params[2], "Address cannot be null"));
        customer.setContactPerson(Objects.requireNonNull(
                params[3], "Contact Person cannot be null"));
    }

    @Override
    public void delete(Customer customer) {
        customerList.remove(customer);
    }

    public void clear(){
        customerList.clear();
    }

    public List<Long> getCodes(){
        return customerList.stream()
                .map(Customer::getId)
                .collect(Collectors.toList());
    }
}

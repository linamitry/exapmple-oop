package ru.example.oop.first.dao;

import ru.example.oop.Product;
import ru.example.oop.first.exception.NotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductDao implements Dao<Product> {
    private final List<Product> productList;

    public ProductDao() {
        productList = new ArrayList<>();
    }

    @Override
    public Product getById(long id) throws NotFoundException {
        return productList.stream().filter(product -> product.getId() == id).findFirst()
                .orElseThrow(()-> new NotFoundException("Product with id=" + id + " not exist"));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product, String[] params) {
        product.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        product.setPrice(new BigDecimal(params[1]));
        product.setDelivery(Boolean.parseBoolean(params[2]));
        product.setDescription(Objects.requireNonNull(
                params[3], "Description cannot be null"));

        productList.add(product);
    }

    public void updateP(long id, Product product) {

    }

    @Override
    public void delete(Product product) {
        productList.remove(product);
    }

    public void clear(){
        productList.clear();
    }

    public List<Long> getCodes(){
        return productList.stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }
}

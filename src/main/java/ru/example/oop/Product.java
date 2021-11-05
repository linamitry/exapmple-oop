package ru.example.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
    private boolean delivery;
    private String description;

    public Product(long id, String name, BigDecimal price, boolean delivery, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.delivery = delivery;
        this.description = description;
    }
}

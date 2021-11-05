package ru.example.oop;

import lombok.Data;

@Data
public class Customer {
    private long id;
    private String name;
    private String phone;
    private String address;
    private String contactPerson;

    public Customer(long id, String name, String phone, String address, String contactPerson) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.contactPerson = contactPerson;
    }
}

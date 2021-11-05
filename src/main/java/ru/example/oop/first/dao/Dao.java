package ru.example.oop.first.dao;

import ru.example.oop.first.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T getById(long id) throws NotFoundException;

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}

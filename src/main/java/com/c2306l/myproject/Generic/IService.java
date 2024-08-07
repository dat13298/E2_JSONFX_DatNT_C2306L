package com.c2306l.myproject.Generic;

import javafx.collections.ObservableList;

public interface IService<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    ObservableList<T> selectAll();
    T getById(int id);
}

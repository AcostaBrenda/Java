package com.medicalClinic.service;

import java.util.List;

public interface IGenericService<T, K> {

    T find(K k);
    T save(T t);
    Boolean delete(T t);
    List<T> findAll();
    T update(T t, K k);

}


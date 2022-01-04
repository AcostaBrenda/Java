package com.clinicaOdontologica.service;

import com.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IGenericaService <T, K> {

    T buscar(K k)throws ResourceNotFoundException;
    T guardar(T t);
    Boolean eliminar(K k);
    List<T> buscarTodos();
    T actualizar(T t, K k) throws ResourceNotFoundException;

}


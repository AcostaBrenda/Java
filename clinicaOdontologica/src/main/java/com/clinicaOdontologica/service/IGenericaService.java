package com.clinicaOdontologica.service;

import java.util.List;

public interface IGenericaService <T> {

    T buscar(Long id);
    T guardar(T t);
    Boolean eliminar(Long id);
    List<T> buscarTodos();
    T actualizar(T t);

}


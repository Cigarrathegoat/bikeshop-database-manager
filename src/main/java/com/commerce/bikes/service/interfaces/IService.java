package com.commerce.bikes.service.interfaces;

import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;

import java.util.List;

public interface IService <T>{

    T save(T t) throws SaveMethodException, ObjectNotFoundException;

    StandardResponseDTO delete(T t) throws ObjectNotFoundException;

    List<T> listAllBikse();

    T update(T t) throws ObjectNotFoundException;
}

package com.commerce.bikes.service.impl;

import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import com.commerce.bikes.repository.entities.Sales;
import com.commerce.bikes.service.interfaces.ISaleService;

import java.util.List;

public class SaleService implements ISaleService {
    @Override
    public Sales save(Sales sales) throws SaveMethodException, ObjectNotFoundException {
        return null;
    }

    @Override
    public StandardResponseDTO delete(Sales sales) throws ObjectNotFoundException {
        return null;

    }

    @Override
    public List<Sales> listAllBikse() {
        return null;
    }

    @Override
    public Sales update(Sales sales) throws ObjectNotFoundException {
        return null;
    }
}

package com.commerce.bikes.service.interfaces;

import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.repository.entities.Bike;

import java.util.List;

public interface IBikeService extends IService<Bike>{


    public List<Bike> listAllBikes();

    public StandardResponseDTO bikeSale(String bikeId, String customerId);

    Bike findBikeById(String bikeId) throws ObjectNotFoundException;
}

package com.commerce.bikes.adapters;

import com.commerce.bikes.apis.dtos.requests.BikeDTO;
import com.commerce.bikes.repository.entities.Bike;

import java.util.List;
import java.util.stream.Collectors;

public class BikeDTOAdapter {

    public static BikeDTO convertTo(Bike bike) {

        BikeDTO bikeDTO = new BikeDTO();

        bikeDTO.setId(bike.getId());
        bikeDTO.setType(bike.getType());
        bikeDTO.setName(bike.getName());
        bikeDTO.setPrice(bike.getPrice());
        bikeDTO.setRimSize(bike.getRimSize());
        bikeDTO.setOwner(bike.getOwner());

        return bikeDTO;
    }

    public static List<BikeDTO> convertToList(List<Bike> bikeList) {
        return bikeList.stream().map(item -> convertTo(item)).collect(Collectors.toList());
    }
}

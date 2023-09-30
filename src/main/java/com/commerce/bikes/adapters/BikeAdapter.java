package com.commerce.bikes.adapters;

import com.commerce.bikes.apis.dtos.requests.BikeDTO;
import com.commerce.bikes.repository.entities.Bike;

import java.util.List;
import java.util.stream.Collectors;

public class BikeAdapter {

    public static Bike convertTo(BikeDTO bikeDTO) {
        return Bike.builder()
                .id(bikeDTO.getId())
                .name(bikeDTO.getName())
                .type(bikeDTO.getType())
                .rimSize(bikeDTO.getRimSize())
                .price(bikeDTO.getPrice())
                .owner(bikeDTO.getOwner())
                .build();
    }

    public static List<Bike> convertToList(List<BikeDTO> bikeDTO) {
        return bikeDTO.stream().map(item -> convertTo(item)).collect(Collectors.toList());
    }
}

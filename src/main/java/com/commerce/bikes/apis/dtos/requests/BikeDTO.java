package com.commerce.bikes.apis.dtos.requests;

import com.commerce.bikes.repository.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BikeDTO {

    private String id;

    private String name;

    private String type;

    private Long rimSize;

    private Long price;

    private String owner;
}

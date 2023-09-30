package com.commerce.bikes.apis.dtos.requests;

import com.commerce.bikes.repository.entities.Bike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;

    private Long age;

    private String cpf;

    private List<Bike> bikes;
}

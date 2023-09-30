package com.commerce.bikes.repository.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer-collection")
public class Customer {

    @Id
    private String id;

    private String name;

    private Long age;

    private String cpf;

    private List<Bike> bikes;


}

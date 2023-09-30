package com.commerce.bikes.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sales-collection")
public class Sales {

    @Id
    private String id;

    private Customer customer;

    private Bike bike;

    private Date saleDate;
}

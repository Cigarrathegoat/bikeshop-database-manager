package com.commerce.bikes.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bike-collection")

public class Bike {

    @Id
    private String id;

    private String name;

    private String type;

    private Long rimSize;

    private Long price;

    private String owner;
}

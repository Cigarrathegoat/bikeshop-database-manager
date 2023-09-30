package com.commerce.bikes.repository;

import com.commerce.bikes.repository.entities.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISalesRepository extends MongoRepository<Sales, String> {
}

package com.commerce.bikes.repository;

import com.commerce.bikes.repository.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<Customer, String> {
}

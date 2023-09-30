package com.commerce.bikes.repository;

import com.commerce.bikes.repository.entities.Bike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBikeRepository extends MongoRepository<Bike, String> {
}

package com.commerce.bikes.service.interfaces;

import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.repository.entities.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer>{

    List<Customer> findCustomerByName(String customerName) throws ObjectNotFoundException;

    void addBike(String customerName, String bikeName) throws ObjectNotFoundException;

    List<Customer> listAllCustomers();
}

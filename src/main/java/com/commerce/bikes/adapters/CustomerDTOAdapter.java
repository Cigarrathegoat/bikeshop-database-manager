package com.commerce.bikes.adapters;

import com.commerce.bikes.apis.dtos.requests.CustomerDTO;
import com.commerce.bikes.repository.entities.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTOAdapter {

    public static CustomerDTO convertTo(Customer customer) {

        return CustomerDTO.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .build();
    }

    public static List<CustomerDTO> convertToList(List<Customer> customerList) {
        return customerList.stream().map(item -> convertTo(item)).collect(Collectors.toList());
    }
}

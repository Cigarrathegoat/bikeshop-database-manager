package com.commerce.bikes.adapters;

import com.commerce.bikes.apis.dtos.requests.CustomerDTO;
import com.commerce.bikes.repository.entities.Customer;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CustomerAdapter {

    public static Customer convertTo(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName().toUpperCase(Locale.ROOT))
                .age(customerDTO.getAge())
                .build();
    }

    public static List<Customer> convertToList(List<CustomerDTO> customerDTO) {
        return customerDTO.stream().map(item -> convertTo(item)).collect(Collectors.toList());
    }
}

package com.commerce.bikes.service.impl;

import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import com.commerce.bikes.repository.ICustomerRepository;
import com.commerce.bikes.repository.entities.Customer;
import com.commerce.bikes.service.interfaces.IBikeService;
import com.commerce.bikes.service.interfaces.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IBikeService bikeService;

    @Override
    public List<Customer> findCustomerByName(String customerName) throws ObjectNotFoundException {
        var customerFind = Arrays.asList(new Customer());
        //personRepository.findPersonByName(personName);
        if (customerFind != null) {
            return customerFind;
        } else {
            throw new ObjectNotFoundException("P02", "Error in finding " + customerName + ".");
        }
    }

    @Override
    public void addBike(String customerName, String bikeId) throws ObjectNotFoundException {
        log.info("initialized personService.addEquipment");
        var customerFind = findCustomerByName(customerName);
        var bikeFind = bikeService
                .findBikeById(bikeId);
        log.info("processing add");
        if (customerFind.get(0).getBikes() == null)
            customerFind.get(0).setBikes(new ArrayList<>());
        customerFind.get(0).getBikes().add(bikeFind);
        //bikeFind.setOwner(customerFind.get(0));
        customerRepository.save(customerFind.get(0));
        log.info("add complete");

    }

    @Override
    public Customer save(Customer customer) throws SaveMethodException, ObjectNotFoundException {
        log.info("initialized PersonService.save");
        if (customer.getName() != null) {
            log.info("Processing save");
            customerRepository.save(customer);
            log.info("save complete");
            return customer;
        } else {
            log.error("validation failed");
            throw new SaveMethodException("P01", "Invalid Person saved");
        }
    }

    @Override
    public StandardResponseDTO delete(Customer customer) throws ObjectNotFoundException {
        log.info("initialized PersonService.delete");
        var personDelete = customerRepository.findById(customer.getId()).orElseThrow(
                () -> new ObjectNotFoundException("P01", "Person Not Found")
        );
        log.info("Processing delete");
        customerRepository.delete(personDelete);
        log.info("delete complete");

        return StandardResponseDTO.builder().code(HttpStatus.OK.value()).message("deleted successfully").build();

    }

    @Override
    public List<Customer> listAllBikse() {
        return null;
    }

    @Override
    public List<Customer> listAllCustomers() {
        log.info("initialized PersonService.listAll");
        log.info("listAll complete");
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) throws ObjectNotFoundException {
        log.info("initialized PersonService.update");
        var personFind = customerRepository.findById(customer.getId());
        var personUpdate = personFind.orElseThrow(
                () -> new ObjectNotFoundException("P01", "Person Not Found")
        );

        log.info("processing update");
        personUpdate.setName(customer.getName());
        personUpdate.setAge(customer.getAge());
        personUpdate.setId(customer.getId());

        log.info("update complete");
        return customerRepository.save(personUpdate);
    }
}

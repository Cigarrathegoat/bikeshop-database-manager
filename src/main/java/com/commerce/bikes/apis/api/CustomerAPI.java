package com.commerce.bikes.apis.api;

import com.commerce.bikes.adapters.CustomerAdapter;
import com.commerce.bikes.adapters.CustomerDTOAdapter;
import com.commerce.bikes.apis.dtos.requests.CustomerDTO;
import com.commerce.bikes.apis.dtos.requests.CustomersNewBikeDTO;
import com.commerce.bikes.apis.dtos.responses.responses.CustomerListResponseDTO;
import com.commerce.bikes.apis.dtos.responses.responses.CustomerResponseDTO;
import com.commerce.bikes.apis.dtos.responses.responses.DeleteResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import com.commerce.bikes.repository.entities.Customer;
import com.commerce.bikes.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/customer")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/new")
    public CustomerResponseDTO addWithBody(@RequestBody CustomerDTO personDTO) throws SaveMethodException,
            ObjectNotFoundException {
        return CustomerResponseDTO.builder()
                .data(
                        CustomerDTOAdapter.convertTo(
                                customerService.save(CustomerAdapter.convertTo(personDTO))
                        )
                ).build();
    }

    @GetMapping("/find/{customer}")
    public CustomerListResponseDTO find(@PathVariable("customer") String customerName) throws ObjectNotFoundException {

        return CustomerListResponseDTO.builder()
                .data(
                        CustomerDTOAdapter.convertToList(
                                customerService.findCustomerByName(customerName)
                        )
                ).build();
    }

    @GetMapping("/customerList")
    public CustomerListResponseDTO listAllCustomers() {
        return CustomerListResponseDTO.builder()
                .data(
                        CustomerDTOAdapter.convertToList(
                                customerService.listAllCustomers()
                        )
                ).build();
    }

    @PutMapping("/change/{name}")
    public CustomerResponseDTO changeWithBody(@RequestBody CustomerDTO personDTO) throws ObjectNotFoundException
             {
        return CustomerResponseDTO.builder()
                .data(
                        CustomerDTOAdapter.convertTo(
                                customerService.update(
                                        CustomerAdapter.convertTo(personDTO)
                                )
                        )
                ).build();
    }

    @PostMapping
    public ResponseEntity addBike(@RequestBody CustomersNewBikeDTO newBikeDTO)
            throws ObjectNotFoundException {

        customerService.addBike(newBikeDTO.getCustomerName(), newBikeDTO.getBikeName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/mongoDB")
    public ResponseEntity addEquipment(@RequestBody Customer customer)
            throws ObjectNotFoundException, SaveMethodException {

        customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<DeleteResponseDTO> delete(@PathVariable("customerId") String customerId)
            throws ObjectNotFoundException {
        customerService.delete(Customer.builder().id(customerId).build());

        return ResponseEntity.ok(DeleteResponseDTO.builder()
                .deleteSuccessMessage("Person successfully deleted")
                .build());
    }
}

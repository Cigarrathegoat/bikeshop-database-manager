package com.commerce.bikes.apis.dtos.responses.responses;

import com.commerce.bikes.apis.dtos.requests.CustomerDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDTO {

    public CustomerDTO data;
}

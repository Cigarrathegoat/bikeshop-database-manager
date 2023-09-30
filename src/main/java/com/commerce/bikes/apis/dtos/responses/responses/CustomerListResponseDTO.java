package com.commerce.bikes.apis.dtos.responses.responses;

import com.commerce.bikes.apis.dtos.requests.CustomerDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerListResponseDTO {

    public List<CustomerDTO> data;
}

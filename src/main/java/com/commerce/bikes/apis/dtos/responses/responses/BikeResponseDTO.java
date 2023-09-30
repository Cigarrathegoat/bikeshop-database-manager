package com.commerce.bikes.apis.dtos.responses.responses;

import com.commerce.bikes.apis.dtos.requests.BikeDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BikeResponseDTO {

    public BikeDTO data;
}

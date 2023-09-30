package com.commerce.bikes.apis.dtos.responses.responses;

import com.commerce.bikes.apis.dtos.requests.BikeDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BikeListResponseDTO {

    public List<BikeDTO> data;
}

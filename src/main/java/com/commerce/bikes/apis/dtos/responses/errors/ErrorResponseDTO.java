package com.commerce.bikes.apis.dtos.responses.errors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {

    private ErrorSpecificationDTO data;
}

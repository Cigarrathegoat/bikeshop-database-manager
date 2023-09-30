package com.commerce.bikes.apis.dtos.responses.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteResponseDTO {

    private String deleteSuccessMessage;
}

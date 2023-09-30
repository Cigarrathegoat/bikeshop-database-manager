package com.commerce.bikes.apis.dtos.responses.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDTO {

    private int code;

    private String message;
}

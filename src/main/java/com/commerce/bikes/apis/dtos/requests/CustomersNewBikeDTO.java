package com.commerce.bikes.apis.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersNewBikeDTO {

    private String customerName;

    private String bikeName;
}

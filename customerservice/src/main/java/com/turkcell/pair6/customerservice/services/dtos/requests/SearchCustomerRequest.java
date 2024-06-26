package com.turkcell.pair6.customerservice.services.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerRequest
{
    private String nationalityId;
    private String customerNo;
    private String accountNumber;
    private String gsmNumber;
    private String middleName;
    private String firstName;
    private String lastName;
    private String orderNumber;
}
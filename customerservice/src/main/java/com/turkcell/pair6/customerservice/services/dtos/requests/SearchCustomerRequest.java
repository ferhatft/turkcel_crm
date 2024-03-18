package com.turkcell.pair6.customerservice.services.dtos.requests;

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
    private int nationalityId;
    private String customerNo;
    private String accountNumber;
    private String gsmNumber;
    private String firstName;
    private String lastName;


}
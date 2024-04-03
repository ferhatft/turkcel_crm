package com.turkcell.pair6.customerservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerResponse {
    private String customerNo;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nationalityId;
}
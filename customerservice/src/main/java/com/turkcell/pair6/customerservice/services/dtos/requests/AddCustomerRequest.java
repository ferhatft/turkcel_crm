package com.turkcell.pair6.customerservice.services.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {
    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String motherName;

    private String fatherName;

    private int nationalityId;

    private Date birthDate;
}

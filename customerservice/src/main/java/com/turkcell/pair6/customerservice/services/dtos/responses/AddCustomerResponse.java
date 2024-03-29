package com.turkcell.pair6.customerservice.services.dtos.responses;


import com.turkcell.pair6.customerservice.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerResponse {


    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String motherName;

    private String fatherName;

    private int nationalityId;

    private Date birthDate;


}

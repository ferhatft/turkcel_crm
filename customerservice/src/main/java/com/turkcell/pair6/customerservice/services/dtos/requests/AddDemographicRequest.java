package com.turkcell.pair6.customerservice.services.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDemographicRequest {
    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Date birthDate;

    @NotBlank
    private String gender;

    private String motherName;

    private String fatherName;

    @NotBlank
    private int nationalityId;
}

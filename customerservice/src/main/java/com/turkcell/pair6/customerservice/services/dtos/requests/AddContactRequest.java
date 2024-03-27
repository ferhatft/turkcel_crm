package com.turkcell.pair6.customerservice.services.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddContactRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String homePhone;

    @NotBlank
    private String mobilePhone;

    @NotBlank
    private String fax;
}

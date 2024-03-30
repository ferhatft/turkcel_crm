package com.turkcell.pair6.customerservice.services.dtos.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {
    private int id;

    private String email;

    private String homePhone;

    private String mobilePhone;

    private String fax;
}

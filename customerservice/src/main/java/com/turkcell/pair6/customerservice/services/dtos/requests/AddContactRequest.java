package com.turkcell.pair6.customerservice.services.dtos.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddContactRequest {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}

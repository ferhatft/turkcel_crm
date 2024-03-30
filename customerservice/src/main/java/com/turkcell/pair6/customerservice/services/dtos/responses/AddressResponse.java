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
public class AddressResponse {
    private int id;

    private String city;

    private String street;

    private String houseNumber;

    private String description;
}

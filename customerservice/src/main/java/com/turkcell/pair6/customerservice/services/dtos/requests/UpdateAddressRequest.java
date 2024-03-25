package com.turkcell.pair6.customerservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    private int id;
    private String city;
    private String street;
    private String houseNumber;
    private String description;
}

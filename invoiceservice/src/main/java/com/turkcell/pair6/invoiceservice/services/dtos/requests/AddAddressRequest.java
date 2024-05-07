package com.turkcell.pair6.invoiceservice.services.dtos.requests;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddAddressRequest {
    private String city;
    private String street;
    private String houseNumber;
    private String description;
    private int customerId;
}

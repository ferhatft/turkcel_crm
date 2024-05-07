package com.turkcell.pair6.customerservice.services.dtos.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SetPrimaryAdressRequest {

    @Min(1)
    private int customerId;

    @Min(1)
    private int addressId;
}

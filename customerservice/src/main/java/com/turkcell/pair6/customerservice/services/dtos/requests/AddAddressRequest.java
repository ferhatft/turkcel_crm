package com.turkcell.pair6.customerservice.services.dtos.requests;

import com.turkcell.core.service.constants.Messages;
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


    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String city;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String street;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String houseNumber;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String description;

    @Min(1)
    private int customerId;
}

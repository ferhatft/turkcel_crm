package com.turkcell.pair6.customerservice.services.dtos.requests;

import com.turkcell.core.service.constants.Messages;
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
public class UpdateContactRequest {
    @Min(1)
    private int id;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String email;

    private String homePhone;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String mobilePhone;

    private String fax;
}

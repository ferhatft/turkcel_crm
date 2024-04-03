package com.turkcell.pair6.customerservice.services.dtos.requests;


import com.turkcell.pair6.customerservice.core.service.constants.Messages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String nationalityId;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String firstName;

    private String middleName;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String lastName;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String gender;

    private String motherName;

    private String fatherName;


    private LocalDate birthDate;
}

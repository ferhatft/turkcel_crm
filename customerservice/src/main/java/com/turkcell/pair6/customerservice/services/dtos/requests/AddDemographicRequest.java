package com.turkcell.pair6.customerservice.services.dtos.requests;


import com.turkcell.core.service.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDemographicRequest {
    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String firstName;

    private String middleName;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String lastName;

    @NotNull(message = Messages.ValidationErrors.FIELD_NOT_NULL)
    private LocalDate birthDate;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String gender;

    private String motherName;

    private String fatherName;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    @Length(min = 11, max = 11, message=Messages.ValidationErrors.SIZE_INVALID)
    private String nationalityId;
}

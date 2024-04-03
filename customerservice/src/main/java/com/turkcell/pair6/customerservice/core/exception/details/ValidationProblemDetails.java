package com.turkcell.pair6.customerservice.core.exception.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setErrorType("https://turkcell.com/exceptions/validation");
    }
}

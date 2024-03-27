package com.turkcell.pair6.customerservice.core.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails() {
        setErrorType("Validation Rule Violation");
    }
}

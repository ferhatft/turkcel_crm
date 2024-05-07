package com.turkcell.core.exceptions.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setErrorType("https://turkcell.com/exceptions/validation");
    }
}

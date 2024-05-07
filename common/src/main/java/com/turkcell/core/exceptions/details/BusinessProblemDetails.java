package com.turkcell.core.exceptions.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setErrorType("https://turkcell.com/exceptions/business");
    }
}

package com.turkcell.pair6.customerservice.core.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails() {
        setErrorType("Business Rule Violation");
    }
}

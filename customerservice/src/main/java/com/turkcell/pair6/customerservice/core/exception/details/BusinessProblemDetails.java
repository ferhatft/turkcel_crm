package com.turkcell.pair6.customerservice.core.exception.details;

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

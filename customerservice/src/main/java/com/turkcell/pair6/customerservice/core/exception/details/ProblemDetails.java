package com.turkcell.pair6.customerservice.core.exception.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String errorType;
    private String detail;
}

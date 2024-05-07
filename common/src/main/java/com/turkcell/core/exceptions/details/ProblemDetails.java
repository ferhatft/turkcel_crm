package com.turkcell.core.exceptions.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String errorType;
}

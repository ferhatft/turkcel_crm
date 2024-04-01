package com.turkcell.pair6.customerservice.core.exception.handlers;

import com.turkcell.pair6.customerservice.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair6.customerservice.core.exception.details.ProblemDetails;
import com.turkcell.pair6.customerservice.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException validException)
    {
        List<FieldError> validationErrors = validException.getBindingResult().getFieldErrors();

        String detail = "";
        for (FieldError error : validationErrors) {
            detail += error.getField() + ": " + error.getDefaultMessage() + "; ";
        }

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setDetail(detail);
        return validationProblemDetails;
    }


    /*
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleOtherExceptions(){

        return new ProblemDetails("Internal Server Error","Some error occured.");
    }
*/


}

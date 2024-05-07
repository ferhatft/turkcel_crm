package com.turkcell.core.exceptions.handlers;


import com.turkcell.core.exceptions.details.BusinessProblemDetails;
import com.turkcell.core.exceptions.details.ValidationProblemDetails;
import com.turkcell.core.exceptions.types.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.turkcell.core.service.abstracts.ValidationHelperService;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ValidationHelperService validationHelperService;
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
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException validException) {


        List<FieldError> fieldErrors = validException.getBindingResult().getFieldErrors();

        Map<String, String> errorDetails = validationHelperService.buildErrorDetails(fieldErrors);
        String detailString = validationHelperService.buildDetailString(errorDetails);

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setDetail(detailString);

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

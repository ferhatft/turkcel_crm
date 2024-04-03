package com.turkcell.pair6.customerservice.core.service.concretes;

import com.turkcell.pair6.customerservice.core.service.abstracts.ValidationHelperService;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationHelperServiceImpl implements ValidationHelperService {
    public Map<String, String> buildErrorDetails(List<FieldError> fieldErrors) {
        Map<String, String> errorDetails = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            errorDetails.put(fieldName, errorMessage);
        }
        return errorDetails;
    }

    public String buildDetailString(Map<String, String> errorDetails) {
        StringBuilder detailStringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : errorDetails.entrySet()) {
            String fieldName = entry.getKey();
            String errorMessage = entry.getValue();
            String detailString = fieldName + ": " + errorMessage;
                detailStringBuilder.append(detailString);
        }
        return detailStringBuilder.toString();
    }
}

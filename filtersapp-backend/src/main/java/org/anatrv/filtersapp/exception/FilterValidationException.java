package org.anatrv.filtersapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FilterValidationException extends RuntimeException {
    
    public FilterValidationException(String errorMessage) {
        super(errorMessage);
    }
}

package org.anatrv.filtersapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "filter id does not exist")
public class ResourceNotFoundException extends RuntimeException {
    
}

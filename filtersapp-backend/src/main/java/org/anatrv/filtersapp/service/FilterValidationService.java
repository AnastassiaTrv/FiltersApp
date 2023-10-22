package org.anatrv.filtersapp.service;

import org.anatrv.filtersapp.exception.FilterValidationException;
import org.anatrv.filtersapp.model.Property;
import org.anatrv.filtersapp.model.dto.FieldDto;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.anatrv.filtersapp.repository.PropertyConditionRepository;
import org.anatrv.filtersapp.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class FilterValidationService implements Validator {

    @Autowired
    private PropertyConditionRepository propertyConditionRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private SpringValidatorAdapter validatorAdapter;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(FilterDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FilterDto filterDto = (FilterDto) target;
        validatorAdapter.validate(filterDto, errors);

        for (FieldDto field : filterDto.getFields()) {
            var propertyId = field.getPropertyId();
            var conditionId = field.getConditionId();

            Optional<Property> propertyOpt = propertyRepository.findById(propertyId);
            if (!propertyOpt.isPresent()) {
                errors.reject("invalid.property.id", format("invalid property id %s", propertyId));
            } else {
                var property = propertyOpt.get();
                var propertyCondition = propertyConditionRepository.findByPropertyIdAndConditionId(propertyId, conditionId);
                if (propertyCondition == null) {
                    // for example 'Amount' property has a 'Starts with' condition but this is not allowed
                    String msg = format("property '%s' condition '%s' does not exist", property.getName(), conditionId);
                    errors.reject("invalid.property.condition", msg);

                } else if (!isValid(field, property.getDataType())) {
                    String msg = format("property '%s' has invalid value '%s'", property.getName(), field.getValue_());
                    errors.reject("invalid.property.datatype", msg);
                }
            }
        }

        if (errors.hasErrors()) {
            String errorMsg = errors.getAllErrors().stream()
            .map(e -> e.getDefaultMessage())
            .collect(Collectors.joining(", "));

            throw new FilterValidationException(errorMsg);
        }
    }

    public boolean isValid(FieldDto field, String type) {
        String value = field.getValue_();

        if (type.equals("number")) {
            return isNumeric(value);

        } else if (type.equals("date")) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            return isDate(value, formatter);
        }

        return true;
    }

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isDate(String value, DateTimeFormatter formatter) {
       try {
            LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    
}

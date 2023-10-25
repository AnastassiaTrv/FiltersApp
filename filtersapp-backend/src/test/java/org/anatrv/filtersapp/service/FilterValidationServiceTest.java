package org.anatrv.filtersapp.service;

import static java.util.Arrays.asList;

import org.anatrv.filtersapp.model.Property;
import org.anatrv.filtersapp.model.PropertyCondition;
import org.anatrv.filtersapp.model.dto.FieldDto;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.anatrv.filtersapp.repository.PropertyConditionRepository;
import org.anatrv.filtersapp.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FilterValidationServiceTest {

    @Mock
    PropertyConditionRepository propertyConditionRepository;

    @Mock
    PropertyRepository propertyRepository;

    @Mock
    SpringValidatorAdapter validatorAdapter;

    @Mock
    MapBindingResult errors;

    @Mock
    Property propertyMock;

    @Mock
    PropertyCondition propertyConditionMock;

    @InjectMocks
    FilterValidationService validationService;

    @Test
    public void validate_shouldCallReject_ifPropertyIdNotFound() {
        List<FieldDto> fields = asList(
            createFieldDto("1", 111111, 1),
            createFieldDto("2", 111111, 1));

        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyRepository.findById(111111)).thenReturn(Optional.empty());
        
        validationService.validate((Object) filter, errors);
        
        verify(errors, times(2)).reject(eq("invalid.property.id"), anyString());
    }

    @Test
    public void validate_shouldCallReject_ifPropertyConditionNotExists() {
        List<FieldDto> fields = asList(
            createFieldDto("1", 1, 1),
            createFieldDto("2", 1, 1));
            
        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyConditionRepository.findByPropertyIdAndConditionId(1, 1)).thenReturn(null);
        when(propertyRepository.findById(1)).thenReturn(Optional.of(propertyMock));
        when(propertyMock.getName()).thenReturn("Amount");
        
        validationService.validate((Object) filter, errors);
        
        verify(errors, times(2)).reject(eq("invalid.property.condition"), anyString());
    }

    @Test
    public void validate_shouldCallReject_ifNumericPropertyHasWrongValue() {
        List<FieldDto> fields = asList(
            createFieldDto("1", 1, 1),
            createFieldDto("wrong", 1, 1));
            
        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyConditionRepository.findByPropertyIdAndConditionId(1, 1)).thenReturn(propertyConditionMock);
        when(propertyRepository.findById(1)).thenReturn(Optional.of(propertyMock));
        when(propertyMock.getName()).thenReturn("Amount");
        when(propertyMock.getDataType()).thenReturn("number");
        
        validationService.validate((Object) filter, errors);
        
        verify(errors).reject(eq("invalid.property.value"), anyString());
    }

    @Test
    public void validate_shouldCallReject_ifDatePropertyHasWrongValue() {
        List<FieldDto> fields = asList(
            createFieldDto("2023-03-29", 1, 1),
            createFieldDto("wrong", 1, 1));
            
        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyConditionRepository.findByPropertyIdAndConditionId(1, 1)).thenReturn(propertyConditionMock);
        when(propertyRepository.findById(1)).thenReturn(Optional.of(propertyMock));
        when(propertyMock.getName()).thenReturn("Date");
        when(propertyMock.getDataType()).thenReturn("date");
        
        validationService.validate((Object) filter, errors);
        
        verify(errors).reject(eq("invalid.property.value"), anyString());
    }

    @Test
    public void validate_shouldNotCallReject_ifNumericPropertyHasCorrectValue() {
        List<FieldDto> fields = asList(
            createFieldDto("1", 1, 1));
            
        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyConditionRepository.findByPropertyIdAndConditionId(1, 1)).thenReturn(propertyConditionMock);
        when(propertyRepository.findById(1)).thenReturn(Optional.of(propertyMock));
        when(propertyMock.getDataType()).thenReturn("number");
        
        validationService.validate((Object) filter, errors);
        
        verify(errors, never()).reject(anyString(), anyString());
    }

    @Test
    public void validate_shouldNotCallReject_ifDatePropertyHasCorrectValue() {
        List<FieldDto> fields = asList(
            createFieldDto("2023-03-29", 1, 1));
            
        FilterDto filter = createFilterDto("Test", "some value", fields);

        when(propertyConditionRepository.findByPropertyIdAndConditionId(1, 1)).thenReturn(propertyConditionMock);
        when(propertyRepository.findById(1)).thenReturn(Optional.of(propertyMock));
        when(propertyMock.getDataType()).thenReturn("date");
        
        validationService.validate((Object) filter, errors);
        
        verify(errors, never()).reject(anyString(), anyString());
    }

    private FilterDto createFilterDto(String name, String someValue, List<FieldDto> fields) {
        FilterDto filter = new FilterDto();
        filter.setName(name);
        filter.setSomeOptionalValue(someValue);
        filter.setFields(fields);
        return filter;
    }

    private FieldDto createFieldDto(String value, Integer propertyId, Integer conditionId) {
        var dto = new FieldDto();
        dto.setValue(value);
        dto.setPropertyId(propertyId);
        dto.setConditionId(conditionId);
        return dto;
    }
    
}

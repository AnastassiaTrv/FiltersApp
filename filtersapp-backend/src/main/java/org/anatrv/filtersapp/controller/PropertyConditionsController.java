package org.anatrv.filtersapp.controller;

import java.util.List;
import static java.util.stream.Collectors.groupingBy;

import org.anatrv.filtersapp.model.Condition;
import org.anatrv.filtersapp.model.PropertyCondition;
import org.anatrv.filtersapp.model.dto.PropertyConditionsDto;
import org.anatrv.filtersapp.service.PropertyConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@CrossOrigin
@RestController
@RequestMapping(path = "api/property-conditions", produces = "application/json")
public class PropertyConditionsController {

    @Autowired
    private PropertyConditionsService propertyConditionService;

    @GetMapping
    public List<PropertyConditionsDto> getAll() {
        return convertToDto(propertyConditionService.getAllPropertyConditions());
    }

    private List<PropertyConditionsDto> convertToDto(List<PropertyCondition> propertyConditions) {
        return propertyConditions.stream()
        .collect(groupingBy(pc -> pc.getProperty().getId()))
        .values()
        .stream()
        .map(this::buildDto)
        .toList();
    }

    private PropertyConditionsDto buildDto(List<PropertyCondition> pcList) {
        return new PropertyConditionsDto(pcList.get(0).getProperty(), extractConditions(pcList));
    }

    private List<Condition> extractConditions(List<PropertyCondition> propertyConditions) {
        return propertyConditions.stream().map(pc -> pc.getCondition()).toList();
    }
    
}

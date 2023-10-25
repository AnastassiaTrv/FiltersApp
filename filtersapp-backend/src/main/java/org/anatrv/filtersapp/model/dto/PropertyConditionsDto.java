package org.anatrv.filtersapp.model.dto;

import java.util.List;

import org.anatrv.filtersapp.model.Condition;
import org.anatrv.filtersapp.model.Property;

import lombok.Data;

@Data
public class PropertyConditionsDto {
    private Property property;
    private List<Condition> conditions;

    public PropertyConditionsDto(Property property, List<Condition> conditions) {
        this.property = property;
        this.conditions = conditions;
    }
}

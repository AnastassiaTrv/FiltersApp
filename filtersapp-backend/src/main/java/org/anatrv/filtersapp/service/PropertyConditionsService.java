package org.anatrv.filtersapp.service;

import java.util.List;

import org.anatrv.filtersapp.model.PropertyCondition;
import org.anatrv.filtersapp.repository.PropertyConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyConditionsService {
    
    @Autowired
    private PropertyConditionRepository propertyConditionRepository;

    public List<PropertyCondition> getAllPropertyConditions() {
        return propertyConditionRepository.findAll();
    }
}

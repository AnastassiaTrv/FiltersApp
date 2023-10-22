package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.PropertyCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyConditionRepository extends JpaRepository<PropertyCondition, Integer> {

    PropertyCondition findByPropertyIdAndConditionId(Integer propertyId, Integer conditionId);
    
}

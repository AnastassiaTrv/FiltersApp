package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.FieldsGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldsGroupRepository extends CrudRepository<FieldsGroup, Integer>{
    
}

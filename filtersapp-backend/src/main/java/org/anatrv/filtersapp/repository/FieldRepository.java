package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer>{
    
}

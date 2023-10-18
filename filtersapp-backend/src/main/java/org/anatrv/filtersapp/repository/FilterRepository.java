package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.Filter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends CrudRepository<Filter, Integer>{
    
}

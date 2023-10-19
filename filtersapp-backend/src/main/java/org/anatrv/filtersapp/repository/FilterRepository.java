package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer>{
    
}

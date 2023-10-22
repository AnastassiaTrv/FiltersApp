package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    
}

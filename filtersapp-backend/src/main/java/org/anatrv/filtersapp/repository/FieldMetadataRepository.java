package org.anatrv.filtersapp.repository;

import org.anatrv.filtersapp.model.FieldMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldMetadataRepository extends CrudRepository<FieldMetadata, Integer>{
    
}

package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FieldMetadata {
    @Id
    private Integer id;
    private String name;
    private String type;
    private Boolean required;
}

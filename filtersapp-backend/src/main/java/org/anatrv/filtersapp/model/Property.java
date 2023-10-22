package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Property {
    @Id
    private Integer id;
    private String name;
    private String dataType;
}

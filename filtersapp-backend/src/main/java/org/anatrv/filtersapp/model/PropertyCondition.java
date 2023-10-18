package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PropertyCondition {
    @Id
    private Integer id;
    private Integer propertyId;
    private Integer conditionId;
}

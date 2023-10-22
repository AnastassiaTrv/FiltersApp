package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class FilterField {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_generator")
    @SequenceGenerator(name = "field_generator", sequenceName = "field_seq", allocationSize = 1)
    private Integer id;
    private String value_;
    private Integer propertyId;
    private Integer conditionId;
}

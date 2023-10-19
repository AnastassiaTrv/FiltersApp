package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class FilterField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value_;

    @ManyToOne
    @JoinColumn(name = "fieldId")
    private Field fieldMetadata;

    @ManyToOne
    @JoinColumn(name = "propertyCondition_id")
    private PropertyCondition propertyCondition;
}

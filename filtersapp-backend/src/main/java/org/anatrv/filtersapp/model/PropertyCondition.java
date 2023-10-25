package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PropertyCondition {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condition_id")
    private Condition condition;
}

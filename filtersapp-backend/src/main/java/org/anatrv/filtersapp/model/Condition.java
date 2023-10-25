package org.anatrv.filtersapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Condition {
    @Id
    private Integer id;
    private String rule;
}

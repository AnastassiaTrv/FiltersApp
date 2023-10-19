package org.anatrv.filtersapp.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filterId")
    private Collection<FilterField> fields = new ArrayList<>();
}

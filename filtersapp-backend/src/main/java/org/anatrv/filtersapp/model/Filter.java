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
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filter_generator")
    @SequenceGenerator(name = "filter_generator", sequenceName = "filter_seq", allocationSize = 1)
    private Integer id;

    private String name;

    private String someOptionalValue;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filterId")
    private Collection<FilterField> fields = new ArrayList<>();
}

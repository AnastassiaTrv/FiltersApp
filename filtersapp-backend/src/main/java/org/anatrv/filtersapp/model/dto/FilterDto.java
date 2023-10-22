package org.anatrv.filtersapp.model.dto;

import java.util.Collection;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * FilterDto is used to transfer data to and from the external world via REST API, while entity models are used to transfer data internally.
 * In our case both models have same structure, but this may be not the case in a real life and sometimes we don't want to expose all model data to the world
 */
@Data
public class FilterDto {
    private Integer id;

    @NotBlank
    private String name;

    private String someOptionalValue;

    @NotEmpty
    private Collection<@Valid FieldDto> fields;
}

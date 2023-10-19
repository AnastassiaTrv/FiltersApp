package org.anatrv.filtersapp.model.dto;

import java.util.Collection;

import lombok.Data;

/**
 * DTO is used to transfer data to external world via REST API, while entity models are used to transfer data internally 
 * and are not exposed further than a service layer
 */

@Data
public class FilterDto {
    private Integer id;
    private String description;
    private Collection<FieldDto> fields;
}

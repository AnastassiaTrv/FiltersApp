package org.anatrv.filtersapp.model.dto;

import lombok.Data;

/**
 * DTO is used to transfer data to external world via REST API, while entity models are used to transfer data internally 
 * and are not exposed further than a service layer
 */

@Data
public class FieldDto {
    private Integer id;
    private String value_;
    private String name;
    private String type;
    private Boolean required;
    private Integer propertyId;
    private Integer conditionId;
}

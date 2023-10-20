package org.anatrv.filtersapp.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO is used to transfer data to external world via REST API, while entity models are used to transfer data internally 
 * and are not exposed further than a service layer
 */

@Data
public class FieldDto {
    @NotNull
    private Integer key;
    private String value_;
    private String name;
    private Integer propertyId;
    private Integer conditionId;
}

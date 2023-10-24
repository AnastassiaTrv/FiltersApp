package org.anatrv.filtersapp.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FieldDto {
    @NotNull(message = "value cannot be null")
    private String value;

    @NotNull(message = "property should be selected")
    private Integer propertyId;

    @NotNull(message = "conditionId should be selected")
    private Integer conditionId;
}

package org.anatrv.filtersapp.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FieldDto {
    @NotNull
    private String value_;

    @NotNull
    private Integer propertyId;

    @NotNull
    private Integer conditionId;
}

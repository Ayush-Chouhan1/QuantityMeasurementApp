package com.app.quantitymeasurement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuantityDTO {

    @NotNull
    private Double value;

    @NotEmpty
    private String unit;

    @NotEmpty
    private String measurementType;
}
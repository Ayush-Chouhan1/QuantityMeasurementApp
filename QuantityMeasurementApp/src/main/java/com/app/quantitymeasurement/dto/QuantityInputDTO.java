package com.app.quantitymeasurement.dto;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;

@Data
public class QuantityInputDTO {

    @Valid
    @Data
    @Builder
    public class QuantityMeasurementDTO {

        private double thisValue;
        private double thatValue;

        private String operation;

        private Double resultValue;
        private String resultString;

        private boolean error;
        private String errorMessage;

        public static QuantityMeasurementDTO fromEntity(
                QuantityMeasurementEntity entity) {

        	
            return QuantityMeasurementDTO.builder()
                    .thisValue(entity.getThisValue())
                    .thatValue(entity.getThatValue())
                    .operation(entity.getOperation())
                    .resultValue(entity.getResultValue())
                    .resultString(entity.getResultString())
                    .error(entity.isError())
                    .errorMessage(entity.getErrorMessage())
                    .build();
        }
    }
    private QuantityDTO thisQuantityDTO;

    @Valid
    private QuantityDTO thatQuantityDTO;
}
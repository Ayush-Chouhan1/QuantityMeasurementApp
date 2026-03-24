package com.app.quantitymeasurement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;

@Service
public class QuantityMeasurementServiceImpl 
        implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementDTO compare(QuantityInputDTO input) {

        try {
            double thisVal = input.getThisQuantityDTO().getValue();
            double thatVal = input.getThatQuantityDTO().getValue();

            boolean result = thisVal == thatVal;

            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.setThisValue(thisVal);
            entity.setThatValue(thatVal);
            entity.setOperation("COMPARE");
            entity.setResultString(String.valueOf(result));
            entity.setError(false);

            repository.save(entity);

            return QuantityMeasurementDTO.fromEntity(entity);

        } catch (Exception e) {
            return handleError(e, input, "COMPARE");
        }
    }

    @Override
    public QuantityMeasurementDTO add(QuantityInputDTO input) {

        try {
            double thisVal = input.getThisQuantityDTO().getValue();
            double thatVal = input.getThatQuantityDTO().getValue();

            double result = thisVal + thatVal;

            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.setThisValue(thisVal);
            entity.setThatValue(thatVal);
            entity.setOperation("ADD");
            entity.setResultValue(result);
            entity.setError(false);

            repository.save(entity);

            return QuantityMeasurementDTO.fromEntity(entity);

        } catch (Exception e) {
            return handleError(e, input, "ADD");
        }
    }

    @Override
    public List<QuantityMeasurementDTO> getHistory(String operation) {

        return repository.findByOperation(operation)
                .stream()
                .map(QuantityMeasurementDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // ===================== ERROR HANDLER =====================
    private QuantityMeasurementDTO handleError(
            Exception e, QuantityInputDTO input, String operation) {

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        if (input != null && input.getThisQuantityDTO() != null) {
            entity.setThisValue(input.getThisQuantityDTO().getValue());
        }

        if (input != null && input.getThatQuantityDTO() != null) {
            entity.setThatValue(input.getThatQuantityDTO().getValue());
        }

        entity.setOperation(operation);
        entity.setError(true);
        entity.setErrorMessage(e.getMessage());

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }
}
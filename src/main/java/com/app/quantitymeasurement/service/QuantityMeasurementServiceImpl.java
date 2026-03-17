package com.app.quantitymeasurement.service;

import java.util.List;

import com.app.quantitymeasurement.entitiy.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveMeasurement(String measurementType,
                                String operationType,
                                double value) {

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setMeasurementType(measurementType);
        entity.setOperationType(operationType);
        entity.setValue(value);

        repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return repository.getAllMeasurements();
    }

    @Override
    public int getTotalMeasurementsCount() {
        return repository.getTotalCount();
    }

    @Override
    public void deleteAllMeasurements() {
        repository.deleteAll();
    }
}
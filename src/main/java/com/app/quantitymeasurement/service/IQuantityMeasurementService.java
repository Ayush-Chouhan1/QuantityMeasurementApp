package com.app.quantitymeasurement.service;

import java.util.List;

import com.app.quantitymeasurement.entitiy.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    void saveMeasurement(String measurementType,
                         String operationType,
                         double value);

    List<QuantityMeasurementEntity> getAllMeasurements();

    int getTotalMeasurementsCount();

    void deleteAllMeasurements();
}
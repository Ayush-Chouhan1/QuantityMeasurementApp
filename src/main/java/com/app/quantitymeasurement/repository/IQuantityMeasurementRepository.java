package com.app.quantitymeasurement.repository;

import java.util.List;

import com.app.quantitymeasurement.entitiy.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity e);

    List<QuantityMeasurementEntity> getAllMeasurements();

    int getTotalCount();

    void deleteAll();
}
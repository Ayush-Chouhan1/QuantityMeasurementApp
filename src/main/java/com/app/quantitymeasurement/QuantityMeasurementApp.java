package com.app.quantitymeasurement;

import com.app.quantitymeasurement.entitiy.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.app.quantitymeasurement.util.ConnectionPool;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool();

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementDatabaseRepository(pool);

        QuantityMeasurementEntity e = new QuantityMeasurementEntity();

        e.setMeasurementType("LENGTH");
        e.setOperationType("COMPARE");
        e.setValue(10);

        repo.save(e);

        System.out.println("Saved Count = " + repo.getTotalCount());
    }
}
package main.java.com.app.quantitymeasurement;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.*;
import com.app.quantitymeasurement.util.*;

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
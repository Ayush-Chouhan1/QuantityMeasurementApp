package main.java.com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity e);

    List<QuantityMeasurementEntity> getAllMeasurements();

    int getTotalCount();

    void deleteAll();
}
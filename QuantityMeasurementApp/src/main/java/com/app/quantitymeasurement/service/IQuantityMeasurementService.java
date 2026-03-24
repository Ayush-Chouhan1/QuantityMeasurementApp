package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityInputDTO.QuantityMeasurementDTO;
import java.util.*;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO add(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getHistory(String operation);
}
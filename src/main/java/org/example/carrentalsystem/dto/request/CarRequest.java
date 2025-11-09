package org.example.carrentalsystem.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.enums.CarStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CarRequest {
    String brand;
    String model;
    Integer year;
    String plateNumber;
    Double pricePerDay;
    CarStatus status;
}

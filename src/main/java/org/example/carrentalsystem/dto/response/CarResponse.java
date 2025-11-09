package org.example.carrentalsystem.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.enums.CarStatus;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CarResponse {
    Long id;
    String brand;
    String model;
    Integer year;
    String plateNumber;
    Double pricePerDay;
    CarStatus status;
}

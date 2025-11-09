package org.example.carrentalsystem.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RentalRequest {
    Long carId;
    Long customerId;
    Long locationPickUp;
    Long locationReturn;
    LocalDate startDate;
    LocalDate endDate;
    Double totalPrice;

}

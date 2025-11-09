package org.example.carrentalsystem.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dao.entity.Customer;
import org.example.carrentalsystem.dao.entity.Location;

import java.time.LocalDate;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RentalResponse {
    Long id;
    Car car;
    Customer customer;
    Location pickupLocation;
    Location returnLocation;
    LocalDate startDate;
    LocalDate endDate;
    Double totalPrice;


}

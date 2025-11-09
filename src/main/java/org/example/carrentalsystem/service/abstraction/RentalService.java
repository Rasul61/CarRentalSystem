package org.example.carrentalsystem.service.abstraction;

import org.example.carrentalsystem.dto.request.RentalRequest;
import org.example.carrentalsystem.dto.response.RentalResponse;

import java.util.List;

public interface RentalService {
    RentalResponse createRental(RentalRequest rentalRequest);
    List<RentalResponse> getAllRentals();
    RentalResponse getRentalById(Long id);
    RentalResponse updateRental(Long id,RentalRequest rentalRequest);
    void deleteById(Long id);
}

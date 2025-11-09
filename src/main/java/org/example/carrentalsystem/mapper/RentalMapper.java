package org.example.carrentalsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dao.entity.Customer;
import org.example.carrentalsystem.dao.entity.Location;
import org.example.carrentalsystem.dao.entity.Rental;
import org.example.carrentalsystem.dao.repository.CarRepository;
import org.example.carrentalsystem.dao.repository.CustomerRepository;
import org.example.carrentalsystem.dao.repository.LocationRepository;
import org.example.carrentalsystem.dto.request.RentalRequest;
import org.example.carrentalsystem.dto.response.RentalResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalMapper {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;

    public Rental requestToEntity(RentalRequest rentalRequest) {
        Car car = carRepository.findById(rentalRequest.getCarId()).
                orElseThrow(() -> new RuntimeException("Not found car with this id : " + rentalRequest.getCarId()));
        Customer customer = customerRepository.findById(rentalRequest.getCustomerId()).
                orElseThrow(() -> new RuntimeException("Not found customer with this id : " + rentalRequest.getCustomerId()));
        Location locationPickUp = locationRepository.findById(rentalRequest.getLocationPickUp()).
                orElseThrow(() -> new RuntimeException("Not found location with this id : " + rentalRequest.getLocationPickUp()));
        Location locationReturn = locationRepository.findById(rentalRequest.getLocationReturn()).
                orElseThrow(() -> new RuntimeException("Not found location with this id : " + rentalRequest.getLocationReturn()));

        return Rental.builder().
                car(car).
                customer(customer).
                pickupLocation(locationPickUp).
                returnLocation(locationReturn).
                startDate(rentalRequest.getStartDate()).
                endDate(rentalRequest.getEndDate()).
                totalPrice(rentalRequest.getTotalPrice()).
                build();

    }

    public static RentalResponse entityToResponse(Rental rental) {
        return RentalResponse.builder().
                id(rental.getId()).
                car(rental.getCar()).
                customer(rental.getCustomer()).
                pickupLocation(rental.getPickupLocation()).
                returnLocation(rental.getReturnLocation()).
                startDate(rental.getStartDate()).
                endDate(rental.getEndDate()).
                totalPrice(rental.getTotalPrice()).
                build();
    }
}

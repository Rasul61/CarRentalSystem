package org.example.carrentalsystem.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dao.entity.Customer;
import org.example.carrentalsystem.dao.entity.Location;
import org.example.carrentalsystem.dao.entity.Rental;
import org.example.carrentalsystem.dao.repository.CarRepository;
import org.example.carrentalsystem.dao.repository.CustomerRepository;
import org.example.carrentalsystem.dao.repository.LocationRepository;
import org.example.carrentalsystem.dao.repository.RentalRepository;
import org.example.carrentalsystem.dto.request.RentalRequest;
import org.example.carrentalsystem.dto.response.RentalResponse;
import org.example.carrentalsystem.exceptions.NotFoundException;
import org.example.carrentalsystem.mapper.RentalMapper;
import org.example.carrentalsystem.service.abstraction.RentalService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.example.carrentalsystem.mapper.RentalMapper.entityToResponse;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;
    private final RentalMapper rentalMapper;

    @Override
    public RentalResponse createRental(RentalRequest rentalRequest) {
        Rental rental = rentalRepository.save(rentalMapper.requestToEntity(rentalRequest));
        rental.setStartDate(LocalDate.now());
        rental.setEndDate(LocalDate.now().plusDays(1));
        long days = ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        rental.setTotalPrice(rental.getCar().getPricePerDay() * days);

        rental = rentalRepository.save(rental);

        return entityToResponse(rental);
    }

    @Override
    public List<RentalResponse> getAllRentals() {
        return rentalRepository.findAll().
                stream().
                map(RentalMapper::entityToResponse).
                toList();
    }

    @Override
    public RentalResponse getRentalById(Long id) {
        Rental rental = rentalRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found rental with this id + " + id));
        return entityToResponse(rental);
    }

    @Override
    public RentalResponse updateRental(Long id, RentalRequest rentalRequest) {
        Rental rental = rentalRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found rental with this id + " + id));
        if (rentalRequest.getCarId() != null) {
            Car car = carRepository.findById(rentalRequest.getCarId()).
                    orElseThrow(() -> new NotFoundException("Not found car with this id + " + id));
            rental.setCar(car);
        }
        if (rentalRequest.getCustomerId() != null) {
            Customer customer = customerRepository.findById(rentalRequest.getCustomerId()).
                    orElseThrow(() -> new NotFoundException("Not found car with this id + " + id));
            rental.setCustomer(customer);
        }
        if (rentalRequest.getLocationPickUp() != null) {
            Location location = locationRepository.findById(rentalRequest.getLocationPickUp()).
                    orElseThrow(() -> new NotFoundException("Not found location pick with this id + " + id));
            rental.setPickupLocation(location);
        }
        if (rentalRequest.getLocationReturn() != null) {
            Location location = locationRepository.findById(rentalRequest.getLocationReturn()).
                    orElseThrow(() -> new NotFoundException("Not found location return with this id + " + id));
            rental.setReturnLocation(location);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        rentalRepository.deleteById(id);

    }
}

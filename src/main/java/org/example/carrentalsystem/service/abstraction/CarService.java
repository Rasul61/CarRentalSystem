package org.example.carrentalsystem.service.abstraction;

import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dto.request.CarRequest;
import org.example.carrentalsystem.dto.response.CarResponse;
import org.example.carrentalsystem.enums.CarStatus;

import java.util.List;

public interface CarService {
    CarResponse createCar(CarRequest carRequest);
    CarResponse getCarById(Long id);
    List<CarResponse> getCarByBrand(String brand);
    CarResponse getCarByPlate(String plateNumber);
    List<CarResponse> getCarByStatus(CarStatus carStatus);
    List<CarResponse> getAllCars();
    CarResponse updateCar(Long id,CarRequest carRequest);
    void deleteCarById(Long id);
}

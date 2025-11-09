package org.example.carrentalsystem.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dao.repository.CarRepository;
import org.example.carrentalsystem.dto.request.CarRequest;
import org.example.carrentalsystem.dto.response.CarResponse;
import org.example.carrentalsystem.enums.CarStatus;
import org.example.carrentalsystem.exceptions.NotFoundException;
import org.example.carrentalsystem.mapper.CarMapper;
import org.example.carrentalsystem.service.abstraction.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.carrentalsystem.mapper.CarMapper.entityToResponse;
import static org.example.carrentalsystem.mapper.CarMapper.requestToEntity;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public CarResponse createCar(CarRequest carRequest) {
        Car car = requestToEntity(carRequest);
        carRepository.save(car);

        return entityToResponse(car);
    }



    @Override
    public CarResponse getCarById(Long id) {
        Car car = carRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found car with this id : " + id));

        return entityToResponse(car);
    }

    @Override
    public List<CarResponse> getCarByBrand(String brand) {

        return carRepository.findByBrand(brand).
                stream().
                map(CarMapper::entityToResponse).
                toList();
    }

    @Override
    public CarResponse getCarByPlate(String plateNumber) {
        Car car = carRepository.findByPlateNumber(plateNumber);
        return entityToResponse(car);
    }

    @Override
    public List<CarResponse> getCarByStatus(CarStatus carStatus) {
        return carRepository.findByStatus(carStatus)
                .stream()
                .map(CarMapper::entityToResponse)
                .toList();
    }


    @Override
    public List<CarResponse> getAllCars() {
        return carRepository.findAll().
                stream().
                map(CarMapper::entityToResponse).
                toList();
    }

    @Override
    public CarResponse updateCar(Long id, CarRequest carRequest) {
        Car car = carRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found car with this id : " + id));

        if (carRequest.getBrand() != null && !carRequest.getBrand().isBlank()) {
            car.setBrand(carRequest.getBrand());
        }
        if (carRequest.getModel() != null && !carRequest.getModel().isBlank()) {
            car.setModel(carRequest.getModel());
        }
        if (carRequest.getYear() != null) {
            car.setYear(carRequest.getYear());
        }
        if (carRequest.getPlateNumber() != null && !carRequest.getPlateNumber().isBlank()) {
            car.setPlateNumber(carRequest.getPlateNumber());
        }
        if (carRequest.getPricePerDay() != null) {
            car.setPricePerDay(carRequest.getPricePerDay());
        }
        if (carRequest.getStatus() != null) {
            car.setStatus(carRequest.getStatus());
        }
        carRepository.save(car);

        return entityToResponse(car);
    }


    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}

package org.example.carrentalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dto.request.CarRequest;
import org.example.carrentalsystem.dto.response.CarResponse;
import org.example.carrentalsystem.enums.CarStatus;
import org.example.carrentalsystem.service.abstraction.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CarResponse createCar(@RequestBody CarRequest carRequest) {
        return carService.createCar(carRequest);
    }

    @GetMapping
    List<CarResponse> findAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/id/{id}")
    CarResponse findById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/brand/{brand}")
    List<CarResponse> findByBrand(@PathVariable String brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/plate/{plate}")
    CarResponse findByPlate(@PathVariable String plate) {
        return carService.getCarByPlate(plate);
    }

    @GetMapping("/status/{status}")
    List<CarResponse> findByStatus(@PathVariable CarStatus status) {
        return carService.getCarByStatus(status);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CarResponse updateCar(@PathVariable Long id, @RequestBody CarRequest carRequest) {
        return carService.updateCar(id, carRequest);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

}

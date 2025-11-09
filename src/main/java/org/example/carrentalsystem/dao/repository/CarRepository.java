package org.example.carrentalsystem.dao.repository;

import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.enums.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    Car findByPlateNumber(String plateNumber);

    List<Car> findByStatus(CarStatus status);

}

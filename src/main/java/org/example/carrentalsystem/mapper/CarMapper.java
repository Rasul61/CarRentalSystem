package org.example.carrentalsystem.mapper;

import org.example.carrentalsystem.dao.entity.Car;
import org.example.carrentalsystem.dto.request.CarRequest;
import org.example.carrentalsystem.dto.response.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public static Car requestToEntity(CarRequest carRequest) {
        return Car.builder().
                brand(carRequest.getBrand()).
                model(carRequest.getModel()).
                year(carRequest.getYear()).
                plateNumber(carRequest.getPlateNumber()).
                pricePerDay(carRequest.getPricePerDay()).
                status(carRequest.getStatus()).
                build();
    }

    public static CarResponse entityToResponse(Car car) {
        return CarResponse.builder().
                id(car.getId()).
                brand(car.getBrand()).
                model(car.getModel()).
                year(car.getYear()).
                plateNumber(car.getPlateNumber()).
                pricePerDay(car.getPricePerDay()).
                status(car.getStatus()).
                build();
    }
}

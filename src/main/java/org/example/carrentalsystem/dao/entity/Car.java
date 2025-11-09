package org.example.carrentalsystem.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.carrentalsystem.enums.CarStatus;

@Data
@Entity
@Builder
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String brand;
    String model;
    Integer year;
    String plateNumber;
    Double pricePerDay;

    @Enumerated(EnumType.STRING)
    CarStatus status;
}

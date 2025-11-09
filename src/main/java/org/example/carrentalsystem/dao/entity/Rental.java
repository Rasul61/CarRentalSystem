package org.example.carrentalsystem.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "rentals")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Car car;

    @ManyToOne
    Customer customer;

    @ManyToOne
    Location pickupLocation;

    @ManyToOne
    Location returnLocation;

    LocalDate startDate;
    LocalDate endDate;
    Double totalPrice;
}


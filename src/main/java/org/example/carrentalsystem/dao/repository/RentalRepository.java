package org.example.carrentalsystem.dao.repository;

import org.example.carrentalsystem.dao.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long> {
}

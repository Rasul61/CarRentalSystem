package org.example.carrentalsystem.dao.repository;

import org.example.carrentalsystem.dao.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
    Location findByName(String name);

    Location findByCity(String city);

    Location findByAddress(String address);
}

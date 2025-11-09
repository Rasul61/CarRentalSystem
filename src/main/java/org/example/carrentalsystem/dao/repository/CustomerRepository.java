package org.example.carrentalsystem.dao.repository;

import org.example.carrentalsystem.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByFullName(String fullName);

    Customer findByPhone(String phoneNumber);
}

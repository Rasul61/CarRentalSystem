package org.example.carrentalsystem.dao.repository;

import org.example.carrentalsystem.dao.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}

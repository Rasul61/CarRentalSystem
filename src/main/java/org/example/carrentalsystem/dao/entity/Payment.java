package org.example.carrentalsystem.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.enums.PaymentMethod;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    Rental rental;

    Double amount;
    LocalDateTime paidAt;

    @Enumerated(EnumType.STRING)
    PaymentMethod method;
}


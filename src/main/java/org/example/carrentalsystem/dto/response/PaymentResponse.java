package org.example.carrentalsystem.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.dao.entity.Rental;
import org.example.carrentalsystem.enums.PaymentMethod;

import java.time.LocalDateTime;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PaymentResponse {
    Long id;
    Rental rental;
    Double amount;
    LocalDateTime paidAt;
    PaymentMethod method;

}

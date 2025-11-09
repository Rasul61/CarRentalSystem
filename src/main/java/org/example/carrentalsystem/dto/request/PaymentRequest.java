package org.example.carrentalsystem.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.carrentalsystem.enums.PaymentMethod;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PaymentRequest {
    Long rentalId;
    Double amount;
    PaymentMethod method;

}

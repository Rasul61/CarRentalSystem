package org.example.carrentalsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Payment;
import org.example.carrentalsystem.dao.entity.Rental;
import org.example.carrentalsystem.dao.repository.RentalRepository;
import org.example.carrentalsystem.dto.request.PaymentRequest;
import org.example.carrentalsystem.dto.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final RentalRepository rentalRepository;

    public Payment requestToEntity(PaymentRequest paymentRequest) {
        Rental rental = rentalRepository.findById(paymentRequest.getRentalId()).
                orElseThrow(() -> new RuntimeException("Not found rental with id : " + paymentRequest.getRentalId()));
        return Payment.builder().
                rental(rental).
                amount(paymentRequest.getAmount()).
                method(paymentRequest.getMethod()).
                build();

    }

    public static PaymentResponse entityToResponse(Payment payment) {
        return PaymentResponse.builder().
                id(payment.getId()).
                rental(payment.getRental()).
                amount(payment.getAmount()).
                paidAt(payment.getPaidAt()).
                method(payment.getMethod()).
                build();

    }
}

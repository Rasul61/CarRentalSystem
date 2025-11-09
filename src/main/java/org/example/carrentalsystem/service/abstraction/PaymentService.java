package org.example.carrentalsystem.service.abstraction;

import org.example.carrentalsystem.dto.request.PaymentRequest;
import org.example.carrentalsystem.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);
    List<PaymentResponse> getAllPayments();
    PaymentResponse getPaymentById(Long id);
    PaymentResponse updatePayment(Long id,PaymentRequest paymentRequest);
    void deletePaymentById(Long id);
}

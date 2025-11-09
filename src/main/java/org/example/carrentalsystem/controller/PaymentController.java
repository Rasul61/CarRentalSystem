package org.example.carrentalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dto.request.PaymentRequest;
import org.example.carrentalsystem.dto.response.PaymentResponse;
import org.example.carrentalsystem.service.abstraction.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping
    List<PaymentResponse> findAll() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/id/{id}")
    PaymentResponse findById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    PaymentResponse updatePayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        return paymentService.updatePayment(id, paymentRequest);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
    }
}

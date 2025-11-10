package org.example.carrentalsystem.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Payment;
import org.example.carrentalsystem.dao.entity.Rental;
import org.example.carrentalsystem.dao.repository.PaymentRepository;
import org.example.carrentalsystem.dao.repository.RentalRepository;
import org.example.carrentalsystem.dto.request.PaymentRequest;
import org.example.carrentalsystem.dto.response.PaymentResponse;
import org.example.carrentalsystem.exceptions.NotEnoughMoneyException;
import org.example.carrentalsystem.exceptions.NotFoundException;
import org.example.carrentalsystem.mapper.PaymentMapper;
import org.example.carrentalsystem.service.abstraction.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.example.carrentalsystem.enums.CarStatus.RENTED;
import static org.example.carrentalsystem.enums.CarStatus.SERVICE;
import static org.example.carrentalsystem.mapper.PaymentMapper.entityToResponse;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final RentalRepository rentalRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.save(paymentMapper.requestToEntity(paymentRequest));
        payment.setPaidAt(LocalDateTime.now());
        Rental rental = rentalRepository.findById(paymentRequest.getRentalId()).
                orElseThrow(() -> new NotFoundException("Not found rental with this id" + paymentRequest.getRentalId()));
        if (paymentRequest.getAmount() < rental.getCar().getPricePerDay()) {
            throw new NotEnoughMoneyException("Fail operation ,need :" + (rental.getTotalPrice() - paymentRequest.getAmount()));
        }
        if (rental.getCar().getStatus() == RENTED || rental.getCar().getStatus() == SERVICE) {
            throw new RuntimeException("This car unavailable :" + rental.getCar().getBrand());
        }
        rental.getCar().setStatus(RENTED);
        payment = paymentRepository.save(payment);

        return entityToResponse(payment);
    }

    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().
                stream().
                map(PaymentMapper::entityToResponse).
                toList();
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found payment with this id : " + id));
        return entityToResponse(payment);
    }

    @Override
    public PaymentResponse updatePayment(Long id, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found payment with this id : " + id));
        if (paymentRequest.getRentalId() != null) {
            Rental rental = rentalRepository.findById(paymentRequest.getRentalId()).
                    orElseThrow(() -> new NotFoundException("Not found rental with this id : " + id));
            payment.setRental(rental);
        }
        if (paymentRequest.getAmount() != null) {
            payment.setAmount(paymentRequest.getAmount());
        }
        if (paymentRequest.getMethod() != null) {
            payment.setMethod(paymentRequest.getMethod());
        }

        return entityToResponse(payment);
    }


    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}

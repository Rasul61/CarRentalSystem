package org.example.carrentalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dto.request.RentalRequest;
import org.example.carrentalsystem.dto.response.RentalResponse;
import org.example.carrentalsystem.service.abstraction.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RentalResponse createPayment(@RequestBody RentalRequest rentalRequest) {
        return rentalService.createRental(rentalRequest);
    }

    @GetMapping
    List<RentalResponse> findAll(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/id/{id}")
    RentalResponse findById(@PathVariable Long id){
        return rentalService.getRentalById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    RentalResponse updateRental(@PathVariable Long id,@RequestBody RentalRequest rentalRequest){
        return rentalService.updateRental(id,rentalRequest);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRental(@PathVariable Long id){
        rentalService.deleteById(id);
    }
}

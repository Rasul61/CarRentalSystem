package org.example.carrentalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dto.request.CustomerRequest;
import org.example.carrentalsystem.dto.response.CustomerResponse;
import org.example.carrentalsystem.service.abstraction.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping
    List<CustomerResponse> findAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    CustomerResponse findByID(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/fullName/{fullName}")
    CustomerResponse findByFullName(@PathVariable String fullName) {
        return customerService.getCustomerByFullName(fullName);
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    CustomerResponse findByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}

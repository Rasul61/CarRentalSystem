package org.example.carrentalsystem.service.abstraction;

import org.example.carrentalsystem.dto.request.CustomerRequest;
import org.example.carrentalsystem.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(Long id);
    CustomerResponse getCustomerByFullName(String fullName);
    CustomerResponse getCustomerByPhoneNumber(String phoneNumber);
    CustomerResponse updateCustomer(Long id,CustomerRequest customerRequest);
    void deleteCustomerById(Long id);
}

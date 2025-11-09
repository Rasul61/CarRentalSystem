package org.example.carrentalsystem.mapper;

import org.example.carrentalsystem.dao.entity.Customer;
import org.example.carrentalsystem.dto.request.CustomerRequest;
import org.example.carrentalsystem.dto.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static Customer requestToEntity(CustomerRequest customerRequest) {
        return Customer.builder().
                fullName(customerRequest.getFullName()).
                email(customerRequest.getEmail()).
                phone(customerRequest.getPhone()).
                build();

    }

    public static CustomerResponse entityToResponse(Customer customer) {
        return CustomerResponse.builder().
                id(customer.getId()).
                fullName(customer.getFullName()).
                email(customer.getEmail()).
                phone(customer.getPhone()).
                build();
    }
}

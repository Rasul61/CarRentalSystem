package org.example.carrentalsystem.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Customer;
import org.example.carrentalsystem.dao.repository.CustomerRepository;
import org.example.carrentalsystem.dto.request.CustomerRequest;
import org.example.carrentalsystem.dto.response.CustomerResponse;
import org.example.carrentalsystem.exceptions.NotFoundException;
import org.example.carrentalsystem.mapper.CustomerMapper;
import org.example.carrentalsystem.service.abstraction.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.carrentalsystem.mapper.CustomerMapper.entityToResponse;
import static org.example.carrentalsystem.mapper.CustomerMapper.requestToEntity;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.save(requestToEntity(customerRequest));
        return entityToResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().
                stream().
                map(CustomerMapper::entityToResponse).
                toList();
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found customer with this id : " + id));
        return entityToResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerByFullName(String fullName) {
        Customer customer = customerRepository.findByFullName(fullName);
        return entityToResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.findByPhone(phoneNumber);
        return entityToResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found customer with this id : " + id));
        if (customerRequest.getFullName() != null && !customerRequest.getFullName().isBlank()) {
            customer.setFullName(customer.getFullName());
        }
        if (customerRequest.getEmail() != null && !customerRequest.getEmail().isBlank()) {
            customer.setEmail(customerRequest.getEmail());
        }
        if (customerRequest.getPhone() != null && !customerRequest.getPhone().isBlank()) {
            customer.setPhone(customerRequest.getPhone());
        }
        customerRepository.save(customer);
        return entityToResponse(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }
}

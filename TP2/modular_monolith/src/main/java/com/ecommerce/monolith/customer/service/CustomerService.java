package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import com.ecommerce.monolith.customer.mapper.CustomerMapper;
import com.ecommerce.monolith.customer.model.Customer;
import com.ecommerce.monolith.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<CustomerDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public CustomerDTO getById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapper.toDTO(customer);
    }

    public CustomerDTO create(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        Customer saved = repository.save(customer);
        return mapper.toDTO(saved);
    }

    public CustomerDTO update(Long id, CustomerRequest request) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        mapper.updateCustomerFromRequest(request, customer);

        Customer updated = repository.save(customer);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Customer getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
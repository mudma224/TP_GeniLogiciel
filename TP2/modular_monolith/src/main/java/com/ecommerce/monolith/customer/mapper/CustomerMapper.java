package com.ecommerce.monolith.customer.mapper;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import com.ecommerce.monolith.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerRequest request);

    void updateCustomerFromRequest(CustomerRequest request, @MappingTarget Customer customer);
}
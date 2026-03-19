package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.dto.OrderDTO;
import com.ecommerce.monolith.order.dto.OrderRequest;
import com.ecommerce.monolith.order.mapper.OrderMapper;
import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.repository.OrderRepository;
import com.ecommerce.monolith.product.model.Product;
import com.ecommerce.monolith.product.service.ProductService;
import com.ecommerce.monolith.customer.model.Customer;
import com.ecommerce.monolith.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    private final ProductService productService;
    private final CustomerService customerService;

    public List<OrderDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public OrderDTO getById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return mapper.toDTO(order);
    }

    public OrderDTO create(OrderRequest request) {

        // 🔹 récupérer Product via service
        Product product = productService.getEntityById(request.getProductId());

        // 🔹 récupérer Customer via service
        Customer customer = customerService.getEntityById(request.getCustomerId());

        // 🔹 créer Order
        Order order = Order.builder()
                .quantity(request.getQuantity())
                .product(product)
                .customer(customer)
                .build();

        Order saved = repository.save(order);

        return mapper.toDTO(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.ProductDTO;
import com.ecommerce.monolith.product.dto.ProductRequest;
import com.ecommerce.monolith.product.mapper.ProductMapper;
import com.ecommerce.monolith.product.model.Product;
import com.ecommerce.monolith.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public ProductDTO getById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapper.toDTO(product);
    }

    public ProductDTO create(ProductRequest request) {
        Product product = mapper.toEntity(request);
        Product saved = repository.save(product);
        return mapper.toDTO(saved);
    }

    public ProductDTO update(Long id, ProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        mapper.updateProductFromRequest(request, product);

        Product updated = repository.save(product);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
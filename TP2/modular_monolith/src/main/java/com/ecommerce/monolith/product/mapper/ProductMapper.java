package com.ecommerce.monolith.product.mapper;

import com.ecommerce.monolith.product.dto.ProductDTO;
import com.ecommerce.monolith.product.dto.ProductRequest;
import com.ecommerce.monolith.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Entity → DTO
    ProductDTO toDTO(Product product);

    // Request → Entity (création)
    Product toEntity(ProductRequest request);

    // Update (important)
    void updateProductFromRequest(ProductRequest request, @MappingTarget Product product);
}
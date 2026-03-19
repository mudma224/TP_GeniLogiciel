package com.ecommerce.monolith.order.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    private Long productId;

    @NotNull
    private Long customerId;
}
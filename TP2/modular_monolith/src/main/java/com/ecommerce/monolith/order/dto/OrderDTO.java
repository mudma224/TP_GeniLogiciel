package com.ecommerce.monolith.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;
    private Integer quantity;

    private Long productId;
    private Long customerId;
}
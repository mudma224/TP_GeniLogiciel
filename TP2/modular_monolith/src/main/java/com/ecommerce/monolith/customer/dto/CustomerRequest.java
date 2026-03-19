package com.ecommerce.monolith.customer.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
}
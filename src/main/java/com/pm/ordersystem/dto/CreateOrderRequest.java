package com.pm.ordersystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateOrderRequest(
        @NotNull(message = "Product Id is required")
        Long productId,

        @Min(value = 1, message = "Quantity must be atleast 1")
        int quantity,

        @NotBlank(message = "Email is required")
        @Email(message = "Must be a valid email")
        String customerEmail
) {
}

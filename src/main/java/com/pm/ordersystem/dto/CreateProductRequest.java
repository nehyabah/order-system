package com.pm.ordersystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(

        @NotBlank(message = "Name is required")
        String name,

        @Min(value = 1, message = "Price must be at least 1")
        double price,

        @Min(value=1, message = "Stock cannot be negative")
        int stockQuantity
) {
}

package com.pm.ordersystem.dto;

public record ProductResponse(
        Long id,
        String name,
        double price,
        int stockQuantity
) {
}

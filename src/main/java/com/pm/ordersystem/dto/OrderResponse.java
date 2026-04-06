package com.pm.ordersystem.dto;

import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        String productName,
        int quantity,
        double totalPrice,
        String customerEmail,
        LocalDateTime orderTime,
        String status
) {
}

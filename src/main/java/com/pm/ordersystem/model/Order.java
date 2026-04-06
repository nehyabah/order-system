package com.pm.ordersystem.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Order {
    public Long id;
    public int quantity;
    public double totalPrice;
    private String customerEmail;
    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;

    public Order() {
    }

    public Order(int quantity, double totalPrice, String customerEmail, LocalDateTime orderTime, Product product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.customerEmail = customerEmail;
        this.product = product;
        this.orderTime = orderTime;
        this.status = OrderStatus.PENDING;
    }
}

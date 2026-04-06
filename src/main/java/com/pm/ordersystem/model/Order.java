package com.pm.ordersystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Product getProduct() {
        return product;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

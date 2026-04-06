package com.pm.ordersystem.events;

import java.io.Serializable;

public class OrderEvent implements Serializable {
    private Long orderId;
    private Long productId;
    private int quantity;
    private String customerEmail;
    private String productName;
    private double totalPrice;

    public OrderEvent() {
    }

    public OrderEvent(double totalPrice, String productName, String customerEmail, int quantity, Long productId, Long orderId) {
        this.totalPrice = totalPrice;
        this.productName = productName;
        this.customerEmail = customerEmail;
        this.quantity = quantity;
        this.productId = productId;
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

package org.example.session02.bai3.models;

import java.util.Date;

public class Order {
    private final String code;
    private final String productName;
    private final long totalAmount;
    private final Date orderDate;

    public Order(String code, String productName, long totalAmount, Date orderDate) {
        this.code = code;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public String getCode() {
        return code;
    }

    public String getProductName() {
        return productName;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}


package com.restaurant.bai5.model;

import java.math.BigDecimal;

public class OrderItem {
    private int dishId;
    private String dishName;
    private BigDecimal unitPrice;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int dishId, String dishName, BigDecimal unitPrice, int quantity) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


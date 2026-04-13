package com.restaurant.bai5.repository;

import com.restaurant.bai5.model.Order;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(int id);
}


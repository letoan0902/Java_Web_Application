package com.restaurant.bai5.repository;

import com.restaurant.bai5.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<Integer, Order> store = new ConcurrentHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    @Override
    public Order save(Order order) {
        if (order.getId() <= 0) {
            order.setId(seq.incrementAndGet());
        }
        store.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }
}


package org.example.session04.bai5.service;

import org.example.session04.bai5.repository.OrderManagementRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    private final OrderManagementRepository repository;

    public OrderManagementService(OrderManagementRepository repository) {
        this.repository = repository;
    }

    public String getOrder(Long id) {
        return repository.getOrder(id);
    }

    public String createOrder() {
        return repository.createOrder();
    }

    public String cancelOrder(Long id) {
        return repository.cancelOrder(id);
    }
}


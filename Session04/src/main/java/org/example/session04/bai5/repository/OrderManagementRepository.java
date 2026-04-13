package org.example.session04.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderManagementRepository {

    public String getOrder(Long id) {
        return "Chi tiet don hang so " + id;
    }

    public String createOrder() {
        return "Da tao don hang moi (POST)";
    }

    public String cancelOrder(Long id) {
        return "Da huy don hang so " + id + " (DELETE)";
    }
}


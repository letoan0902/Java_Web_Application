package com.restaurant.bai5.service;

import com.restaurant.bai5.model.Order;
import com.restaurant.bai5.model.OrderItem;
import com.restaurant.bai5.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createSampleOrder() {
        Order order = new Order(0, "Khách mẫu");
        order.getItems().add(new OrderItem(1, "Cá hồi nướng", new BigDecimal("150000"), 1));
        order.getItems().add(new OrderItem(3, "Salad", new BigDecimal("60000"), 2));

        // View phải "ngu ngốc": tính toán tổng tiền nằm ở Service
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : order.getItems()) {
            total = total.add(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        order.setTotal(total);

        return orderRepository.save(order);
    }
}


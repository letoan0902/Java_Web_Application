package com.restaurant.bai5.controller;

import com.restaurant.bai5.model.Order;
import com.restaurant.bai5.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai5")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/smart-order")
    public String smartOrder(Model model) {
        Order order = orderService.createSampleOrder();
        model.addAttribute("order", order);
        return "bai5/smart-order";
    }
}


package org.example.session04.bai5.controller;

import org.example.session04.bai5.service.OrderManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai5/orders")
public class OrderManagementController {

    private final OrderManagementService service;

    public OrderManagementController(OrderManagementService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @PostMapping
    @ResponseBody
    public String createOrder() {
        return service.createOrder();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String cancelOrder(@PathVariable Long id) {
        return service.cancelOrder(id);
    }
}


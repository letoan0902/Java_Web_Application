package org.example.session04.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai3")
public class OrderDetailsController {

    // Chon Cach A: /bai3/orders/5 (ID nam tren path)
    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderDetails(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }
}


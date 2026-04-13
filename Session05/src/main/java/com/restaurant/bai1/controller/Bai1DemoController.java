package com.restaurant.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai1")
public class Bai1DemoController {

    @GetMapping("/home")
    public String home() {
        return "bai1/home";
    }
}


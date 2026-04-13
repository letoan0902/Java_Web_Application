package com.restaurant.bai2.controller;

import com.restaurant.bai2.service.DishService;
import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bai2")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public String list(Model model) {
        List<Dish> dishList = dishService.getMenu();
        model.addAttribute("dishList", dishList);
        return "bai2/dish-list";
    }
}


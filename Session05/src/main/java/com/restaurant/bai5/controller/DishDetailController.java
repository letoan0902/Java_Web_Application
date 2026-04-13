package com.restaurant.bai5.controller;

import com.restaurant.common.model.Dish;
import com.restaurant.common.repository.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/bai5")
public class DishDetailController {

    private final DishRepository dishRepository;

    public DishDetailController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/dish/{id}")
    public String detail(@PathVariable int id, Model model) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish not found"));
        model.addAttribute("dish", dish);
        return "bai5/dish-detail";
    }
}


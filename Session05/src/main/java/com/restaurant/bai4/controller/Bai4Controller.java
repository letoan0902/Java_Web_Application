package com.restaurant.bai4.controller;

import com.restaurant.bai4.service.Bai4DishService;
import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Controller
@RequestMapping("/bai4")
public class Bai4Controller {

    private final Bai4DishService bai4DishService;

    public Bai4Controller(Bai4DishService bai4DishService) {
        this.bai4DishService = bai4DishService;
    }

    @GetMapping("/dishes")
    public String listDishes(Model model) {
        List<Dish> dishList = bai4DishService.findAll();
        model.addAttribute("dishList", dishList);
        return "bai4/dish-list";
    }

    @GetMapping("/dish/{id}")
    public String dishDetail(@PathVariable int id, Model model) {
        Dish dish = bai4DishService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy món ăn!"));
        model.addAttribute("dish", dish);
        return "bai4/dish-detail";
    }
}

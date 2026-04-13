package com.restaurant.bai4.service;

import com.restaurant.common.model.Dish;

import java.util.List;
import java.util.Optional;

public interface Bai4DishService {
    List<Dish> findAll();

    Optional<Dish> findById(int id);
}

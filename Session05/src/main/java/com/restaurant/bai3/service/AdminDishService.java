package com.restaurant.bai3.service;

import com.restaurant.common.model.Dish;

import java.util.List;
import java.util.Optional;

public interface AdminDishService {
    List<Dish> findAll();

    Optional<Dish> findById(int id);

    void save(Dish dish);
}

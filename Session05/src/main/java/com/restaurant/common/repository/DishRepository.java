package com.restaurant.common.repository;

import com.restaurant.common.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> findAll();

    Optional<Dish> findById(int id);

    void save(Dish dish);
}


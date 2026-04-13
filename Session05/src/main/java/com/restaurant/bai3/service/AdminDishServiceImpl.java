package com.restaurant.bai3.service;

import com.restaurant.common.model.Dish;
import com.restaurant.common.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminDishServiceImpl implements AdminDishService {

    private final DishRepository dishRepository;

    public AdminDishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }
}

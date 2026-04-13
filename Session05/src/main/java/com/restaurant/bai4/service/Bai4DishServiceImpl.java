package com.restaurant.bai4.service;

import com.restaurant.common.model.Dish;
import com.restaurant.common.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Bai4DishServiceImpl implements Bai4DishService {

    private final DishRepository dishRepository;

    public Bai4DishServiceImpl(DishRepository dishRepository) {
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
}

package com.restaurant.bai2.service;

import com.restaurant.common.model.Dish;
import com.restaurant.common.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getMenu() {
        return dishRepository.findAll();
    }
}


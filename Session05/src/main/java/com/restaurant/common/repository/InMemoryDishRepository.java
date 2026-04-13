package com.restaurant.common.repository;

import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryDishRepository implements DishRepository {

    private final ConcurrentHashMap<Integer, Dish> store = new ConcurrentHashMap<>();

    public InMemoryDishRepository() {
        // seed data
        save(new Dish(1, "Cá hồi nướng", new BigDecimal("150000"), true));
        save(new Dish(2, "Bò lúc lắc", new BigDecimal("120000"), false));
        save(new Dish(3, "Salad", new BigDecimal("60000"), true));
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> result = new ArrayList<>(store.values());
        result.sort(Comparator.comparingInt(Dish::getId));
        return result;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void save(Dish dish) {
        store.put(dish.getId(), dish);
    }
}


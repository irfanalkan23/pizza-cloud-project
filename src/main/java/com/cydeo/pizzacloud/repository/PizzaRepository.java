package com.cydeo.pizzacloud.repository;

import com.cydeo.pizzacloud.exception.PizzaNotFoundException;
import com.cydeo.pizzacloud.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PizzaRepository {

    private static List<Pizza> pizzaList = new ArrayList<>();

    public Pizza createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
        return pizzaToSave;
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

    public Pizza findById(UUID pizzaId) {

        return pizzaList.stream()
                .filter(pizza -> pizza.getId().equals(pizzaId))
                .findFirst().orElseThrow(()->new PizzaNotFoundException("Pizza not found!"));
    }
}

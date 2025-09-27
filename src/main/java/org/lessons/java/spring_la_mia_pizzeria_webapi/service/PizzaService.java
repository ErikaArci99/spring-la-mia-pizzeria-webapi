package org.lessons.java.spring_la_mia_pizzeria_webapi.service;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_webapi.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// service = logica di business
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    // restituisce tutte le pizze/
    public List<Pizza> findAll() {
        return repository.findAll();
    }

    // trova pizza per id
    public Optional<Pizza> findById(Long id) {
        return repository.findById(id);
    }

    // crea nuova pizza
    public Pizza create(Pizza pizza) {
        return repository.save(pizza);
    }

    // aggiorna pizza esistente
    public Pizza update(Long id, Pizza pizza) {
        pizza.setId(id);
        return repository.save(pizza);
    }

    // elimina pizza
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

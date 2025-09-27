package org.lessons.java.spring_la_mia_pizzeria_webapi.controller;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_webapi.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pizze")
@CrossOrigin
public class PizzaRestController {

    @Autowired
    private PizzaService service;

    // INDEX -> lista pizze
    @GetMapping
    public List<Pizza> index() {
        return service.findAll();
    }

    // SHOW -> dettagli di una pizza
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> show(@PathVariable Long id) {
        Optional<Pizza> pizza = service.findById(id);

        if (pizza.isEmpty()) {
            // se non esiste la pizza → 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // se esiste → 200 + oggetto
        return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
    }

    // STORE -> crea una nuova pizza
    @PostMapping
    public ResponseEntity<Pizza> store(@RequestBody Pizza pizza) {
        Pizza created = service.create(pizza);
        // restituisco la pizza creata con 201 Created
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // UPDATE -> modifica pizza esistente
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> update(@PathVariable Long id, @RequestBody Pizza pizza) {
        Optional<Pizza> existing = service.findById(id);

        if (existing.isEmpty()) {
            // se non esiste → 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // se esiste aggiorno e restituisco 200 + oggetto aggiornato
        Pizza updated = service.update(id, pizza);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // DELETE -> elimina una pizza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Pizza> existing = service.findById(id);

        if (existing.isEmpty()) {
            // se non esiste → 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // se esiste la elimino e restituisco 204 No Content
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

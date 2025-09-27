package org.lessons.java.spring_la_mia_pizzeria_webapi.repository;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

// repository = accesso al database/
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}

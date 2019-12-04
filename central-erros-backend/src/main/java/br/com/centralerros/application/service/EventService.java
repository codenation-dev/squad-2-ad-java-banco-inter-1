package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();
    Optional<Event> findById(Long id);
    Event findEventByCreated_at(LocalDateTime created_at);
    Event findByLevel(String name);
    Event findByCategory(String name);
    Event findByEnviroment(String name);
    Event save(Event event);
    Long delete(Long id);
    Event delete(Event event);

}

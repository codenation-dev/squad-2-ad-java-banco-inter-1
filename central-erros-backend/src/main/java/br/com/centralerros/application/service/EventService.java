package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findEvents(EventFilterDto filter);
    Event save(Event event);
    Long delete(Long id);
    Event delete(Event event);
}

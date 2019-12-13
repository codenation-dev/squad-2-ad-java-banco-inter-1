package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;

import java.util.List;

public interface EventRepository {
    List<Event> findEvents(EventFilterDto filter);
}

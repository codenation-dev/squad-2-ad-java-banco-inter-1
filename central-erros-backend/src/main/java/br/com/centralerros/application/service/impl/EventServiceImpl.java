package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.repository.impl.EventRepositoryImpl;
import br.com.centralerros.application.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepositoryImpl eventRepository;

    @Override
    public List<Event> findEvents(EventFilterDto filter) {
        return eventRepository.findEvents(filter);
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public Event delete(Event event) {
        return null;
    }
}

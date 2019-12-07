package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Enviroment;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.repository.EventRepository;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public EventVO save(EventVO eventVO) {
        ModelMapper modelMapper = new ModelMapper();
        Event event = modelMapper.map(eventVO, Event.class);

        return modelMapper.map(save(event), EventVO.class);
    }

    @Override
    public Long delete(Long id) {
        eventRepository.deleteById(id);
        return id;
    }

    @Override
    public Event delete(Event event) {
        eventRepository.delete(event);
        return event;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();

    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);

    }

    @Override
    public List<Event> findEventByCreated_at(LocalDateTime created_at) {
        return eventRepository.findEventByCreated_at(created_at);
    }

    @Override
    public List<Event> findByLevel(String name) {
        return eventRepository.findByLevel(name);

    }

    @Override
    public List<Event> findByCategory(String name) {
        return eventRepository.findByCategory(name);

    }

    @Override
    public List<Event> findByEnviroment(String name) {
        return eventRepository.findByEnviroment(name);

    }

    @Override
    public List<Event> findByCreatedAtEEnviroment(LocalDateTime created_at, Enviroment enviroment) {
        return eventRepository.findByCreatedAtEEnviroment(created_at, enviroment);
    }

    @Override
    public List<Event> findByCreatedAtEEnviromentECategory(LocalDateTime created_at, Enviroment enviroment, Category category) {
        return eventRepository.findByCreatedAtEEnviromentECategory(created_at, enviroment, category);
    }

    @Override
    public List<Event> findByDataCreatedEEnviromentECategoryELevel(LocalDateTime created_at, Enviroment enviroment, Category category, Level level) {
        return eventRepository.findByDataCreatedEEnviromentECategoryELevel(created_at, enviroment, category, level);
    }

}

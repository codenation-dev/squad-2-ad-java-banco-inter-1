package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.repository.EventRepositoryJpa;
import br.com.centralerros.application.domain.repository.impl.EventRepositoryImpl;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.EventService;
import br.com.centralerros.application.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepositoryImpl eventRepositoryHibernate;

    @Autowired
    EventRepositoryJpa eventRepository;


    @Override
    public List<Event> findEvents(EventFilterDto filter) {
        return eventRepositoryHibernate.findEvents(filter);
    }

    @Override
    public EventVO findById(Long id) {
        return MapperUtils.instance().map(eventRepository.findById(id), EventVO.class);
    }


    @Override
    public EventVO save(Event event) {
        Event eventPersist = eventRepository.save(event);
        return MapperUtils.instance().map(eventPersist, EventVO.class);
    }

    @Override
    public Long delete(Long id) {
        eventRepository.deleteById(id);
        return id;
    }

    @Override
    public EventVO delete(Event event) {
        eventRepository.delete(event);
        return MapperUtils.instance().map(event, EventVO.class);
    }

    @Override
    public EventVO delete(EventVO eventVo) {
        Event event = MapperUtils.instance().map(eventVo, Event.class);
        delete(event);

        return eventVo;
    }

    @Override
    public List<EventVO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }


    @Override
    public List<EventVO> findAllFromUser(UserVO userVO) {
        User user = MapperUtils.instance().map(userVO, User.class);

        List<Event> events = eventRepository.findAllFromUser(user.getId());
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }
}

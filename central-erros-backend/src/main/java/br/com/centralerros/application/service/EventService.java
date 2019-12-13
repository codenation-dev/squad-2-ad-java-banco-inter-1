package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.Level;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findEvents(EventFilterDto filter);

    Event save(Event event);
    //Event save(EventVo eventVo);
    Long delete(Long id);
    Event delete(Event event);


}

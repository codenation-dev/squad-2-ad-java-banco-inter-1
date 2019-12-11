package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.vo.EventVO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();
    Optional<Event> findById(Long id);
    List<Event> findEventByCreatedAt(LocalDateTime created_at);
    List<Event> findByLevel(String name);
    List<Event> findByCategory(String name);
    List<Event> findByEnvironment(String name);
    List<Event> findByCreatedAtEEnvironment(LocalDateTime  created_at, Environment environment);
    List<Event> findByCreatedAtEEnvironmentECategory( LocalDateTime created_at, Environment environment, Category category);
    List<Event> findByDataCreatedEEnvironmentECategoryELevel(LocalDateTime created_at, Environment environment,Category category, Level level);

    Event save(Event event);
    EventVO save(EventVO eventVO);
    Long delete(Long id);
    Event delete(Event event);


}

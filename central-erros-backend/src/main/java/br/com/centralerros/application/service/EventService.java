package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Enviroment;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.Level;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();
    Optional<Event> findById(Long id);
    List<Event> findEventByCreated_at(LocalDateTime created_at);
    List<Event> findByLevel(String name);
    List<Event> findByCategory(String name);
    List<Event> findByEnviroment(String name);
    List<Event> findByCreatedAtEEnviroment(LocalDateTime  created_at, Enviroment enviroment);
    List<Event> findByCreatedAtEEnviromentECategory( LocalDateTime created_at, Enviroment enviroment, Category category);
    List<Event> findByDataCreatedEEnviromentECategoryELevel(LocalDateTime created_at, Enviroment enviroment,Category category, Level level);
    Event save(Event event);
    //Event save(EventVo eventVo);
    Long delete(Long id);
    Event delete(Event event);


}

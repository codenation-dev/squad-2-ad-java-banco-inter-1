package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //findByDataCreated
    @Transactional
    Event findEventByCreated_at (@Param("created_at") LocalDateTime created_at);

    @Transactional
    @Query(value = "SELECT l.name FROM centralerros.level l, centralerros.event e " +
            "WHERE l.id = e.level_id " +
            "AND l.name = :name",nativeQuery = true)
    Event findByLevel (@Param("name") String name);

    @Transactional
    @Query(value = "SELECT c.name FROM centralerros.category c, centralerros.event e " +
            "WHERE c.id = e.category_id " +
            "AND c.name = :name",nativeQuery = true)
    Event findByCategory (@Param("name") String name);

    @Transactional
    @Query(value = "SELECT en.name FROM centralerros.enviroment en, centralerros.event e " +
            "WHERE en.id = e.enviroment_id " +
            "AND en.name = :name",nativeQuery = true)
    Event findByEnviroment (@Param("name") String name);


}

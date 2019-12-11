package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.event e " +
            "WHERE e.created_at = :created_at", nativeQuery = true)
    List<Event> findEventByCreatedAt (@Param("created_at") LocalDateTime created_at);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.event e " +
            "WHERE e.created_at = :created_at " +
            "AND environment = :environment",nativeQuery = true)
    List<Event> findByCreatedAtEEnvironment(@Param("created_at") LocalDateTime created_at, @Param("environment") Environment environment);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.event e " +
            "WHERE e.created_at = :created_at " +
            "AND environment = :environment " +
            "AND category = :category ",nativeQuery = true)
    List<Event> findByCreatedAtEEnvironmentECategory(@Param("created_at") LocalDateTime created_at, @Param("environment") Environment environment, @Param("category") Category category);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.event e " +
            "WHERE e.created_at = :created_at " +
            "AND environment = :environment " +
            "AND category = :category " +
            "AND level = :level",nativeQuery = true)
    List<Event> findByDataCreatedEEnvironmentECategoryELevel(@Param("created_at") LocalDateTime created_at, @Param("environment") Environment environment, @Param("category") Category category, @Param("level") Level level);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.level l, centralerros.event e " +
            "WHERE l.id = e.level_id " +
            "AND l.name = :name",nativeQuery = true)
    List<Event> findByLevel (@Param("name") String name);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.category c, centralerros.event e " +
            "WHERE c.id = e.category_id " +
            "AND c.name = :name",nativeQuery = true)
    List<Event> findByCategory (@Param("name") String name);

    @Transactional
    @Query(value = "SELECT e.* FROM centralerros.environment en, centralerros.event e " +
            "WHERE en.id = e.environment_id " +
            "AND en.name = :name",nativeQuery = true)
    List<Event> findByEnviroment (@Param("name") String name);
}

package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepositoryJpa extends JpaRepository<Event, Long> {
    @Override
    <S extends Event> S save(S s);

    @Override
    Optional<Event> findById(Long aLong);

    @Override
    List<Event> findAll();

    @Transactional
    @Query(value = "SELECT e.* FROM event e WHERE user_id = :user_id ", nativeQuery = true)
    List<Event> findAllFromUser(@Param("user_id") Long userId);

}

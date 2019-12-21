package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EventRepositoryJpa extends JpaRepository<Event, Long> {
    @Override
    <S extends Event> S save(S s);

    @Override
    List<Event> findAll();

    @Transactional
    @Query(value = "SELECT e.* FROM event e WHERE user_id = :user_id ", nativeQuery = true)
    List<Event> findAllFromUser(@Param("user_id") Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE event SET user_id =:user_id WHERE id=:id", nativeQuery = true)
    void findEventByIdAndUpdateUserId(@Param("user_id") Long user_id, @Param("id") Long id);


}

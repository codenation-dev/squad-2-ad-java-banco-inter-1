package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    @Transactional
    Level findLevelByName (@Param("name") String name);

}

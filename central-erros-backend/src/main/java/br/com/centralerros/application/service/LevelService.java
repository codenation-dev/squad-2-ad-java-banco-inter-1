package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {

    /*- Level
findAll
findById
findByName
save
update
delete (safe delete)*/

    List<Level> findAll();
    Optional<Level> findById(Long id);
    Level findByName(String name);
    Level save(Level level);
    Level delete(Level level);

}

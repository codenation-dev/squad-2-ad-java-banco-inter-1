package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    List<Level> findAll();
    Level findById(int id);
    Level findByName(String name);
}

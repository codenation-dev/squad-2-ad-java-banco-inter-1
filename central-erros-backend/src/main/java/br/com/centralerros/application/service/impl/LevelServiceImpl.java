package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.repository.LevelRepository;
import br.com.centralerros.application.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelRepository levelRepository;

    @Override
    public List<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }

    @Override
    public Level findByName(String name) {
        return levelRepository.findLevelByName(name);
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level delete(Level level) {

        levelRepository.delete(level);
        return level;
    }


}

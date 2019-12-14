package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelServiceImpl implements LevelService {

    @Override
    public List<Level> findAll() {
        return Arrays.asList(LevelEnum.values())
                .stream()
                .map(l -> new Level(l.getValue(), l.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Level findById(int id) {

        return Arrays.asList(
                LevelEnum.values())
                .stream()
                .filter( l -> l.getValue() == id)
                .map(l -> new Level(id, l.toString()))
                .findFirst().orElse(null);
    }

    @Override
    public Level findByName(String name) {

        return Arrays.asList(
                LevelEnum.values())
                .stream()
                .filter( l -> l.toString() == name)
                .map(l -> new Level(l.getValue(), name))
                .findFirst().orElse(null);
    }
}

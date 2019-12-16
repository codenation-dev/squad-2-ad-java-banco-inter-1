package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.service.EnvironmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {


    @Override
    public List<Environment> findAll() {
        return Arrays.asList(EnvironmentEnum.values())
                .stream()
                .map(e -> new Environment(e.getValue(), e.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Environment findById(int id) {

        return Arrays.asList(
                EnvironmentEnum.values())
                .stream()
                .filter( e -> e.getValue() == id)
                .map(e -> new Environment(id, e.toString()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Environment findByName(String name) {
        return Arrays.asList(
                EnvironmentEnum.values())
                .stream()
                .filter( e -> e.toString().equals(name))
                .map(e -> new Environment(e.getValue(), name))
                .findFirst()
                .orElse(null);
    }
}

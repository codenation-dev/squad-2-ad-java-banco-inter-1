package br.com.centralerros.application.service;


import br.com.centralerros.application.domain.entity.Environment;

import java.util.List;

public interface EnvironmentService {
    List<Environment> findAll();
    Environment findById(int id);
    Environment findByName(String name);
}

package br.com.centralerros.application.service;


import br.com.centralerros.application.domain.entity.Environment;

import java.util.List;
import java.util.Optional;

public interface EnvironmentService {

    Optional<Environment> findById(Long id);
    List<Environment> findAll();
    Environment findByName(String name);
    Environment save(Environment environment);
    Environment delete(Environment environment);

}

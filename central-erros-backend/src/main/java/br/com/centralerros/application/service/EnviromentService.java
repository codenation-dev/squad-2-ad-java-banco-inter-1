package br.com.centralerros.application.service;


import br.com.centralerros.application.domain.entity.Enviroment;

import java.util.List;
import java.util.Optional;

public interface EnviromentService {

    Optional<Enviroment> findById(Long id);
    List<Enviroment> findAll();
    Enviroment findByName(String name);
    Enviroment save(Enviroment enviroment);
    Enviroment delete(Enviroment enviroment);

}

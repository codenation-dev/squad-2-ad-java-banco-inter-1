package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {

    Optional<Application> findById(Long id);
    Application findByName(String name);
    Application save(Application application);
    Application delete(Application application);
    Long deleteById(Long id);
    List<Application> findAll();


}

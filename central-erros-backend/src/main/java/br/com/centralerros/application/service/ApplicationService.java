package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.vo.ApplicationVO;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {

    Optional<Application> findById(Long id);
    Application findByName(String name);
    ApplicationVO save(Application application);
    Application delete(Application application);
    Long deleteById(Long id);
    List<Application> findAll();


}

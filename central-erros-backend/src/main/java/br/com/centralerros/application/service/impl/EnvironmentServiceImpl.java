package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.repository.EnvironmentRepository;
import br.com.centralerros.application.service.EnvironmentService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    EnvironmentRepository environmentRepository;

    @Override
    public Optional<Environment> findById(Long id){
        return environmentRepository.findById(id);
    }

    @Override
    public List<Environment> findAll(){
        return environmentRepository.findAll();

    }

    @Override
    public Environment findByName(String name){

        return environmentRepository.findEnviromentByName(name);
    }

    @Override
    public Environment save(Environment environment){
        return environmentRepository.save(environment);

    }

    @Override
    public Environment delete(Environment environment){
        environmentRepository.delete(environment);
        return environment;

    }

}

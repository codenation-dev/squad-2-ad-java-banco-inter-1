package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Enviroment;
import br.com.centralerros.application.domain.repository.EnviromentRepository;
import br.com.centralerros.application.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnviromentServiceImpl implements EnviromentService {

    @Autowired
    EnviromentRepository enviromentRepository;

    @Override
    public Optional<Enviroment> findById(Long id){
        return enviromentRepository.findById(id);
    }

    @Override
    public List<Enviroment> findAll(){
        return enviromentRepository.findAll();

    }

    @Override
    public Enviroment findByName(String name){
        return enviromentRepository.findEnviromentByName(name);
    }

    @Override
    public Enviroment save(Enviroment enviroment){
        return enviromentRepository.save(enviroment);

    }

    @Override
    public Enviroment delete(Enviroment enviroment){
        enviromentRepository.delete(enviroment);
        return enviroment;

    }

}

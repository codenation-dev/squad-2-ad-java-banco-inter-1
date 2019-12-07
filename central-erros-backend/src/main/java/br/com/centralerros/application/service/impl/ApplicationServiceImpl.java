package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.repository.ApplicationRepository;
import br.com.centralerros.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    /*findAll
findById
findByName
save
update
delete (safe delete)*/

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Optional<Application> findById(Long id){

        return applicationRepository.findById(id);

    }

    @Override
    public Application findByName(String name){
        return applicationRepository.findApplicationByName(name);

    }

    @Override
    public Application save(Application application){
        return applicationRepository.save(application);

    }

    @Override
    public Application delete(Application application){
        applicationRepository.delete(application);
        return application;
    }



}

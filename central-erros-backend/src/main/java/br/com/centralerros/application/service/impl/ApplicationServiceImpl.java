package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.repository.ApplicationRepository;
import br.com.centralerros.application.domain.vo.ApplicationVO;
import br.com.centralerros.application.service.ApplicationService;
import br.com.centralerros.application.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {



    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Optional<Application> findById(Long id){

        return applicationRepository.findById(id);

    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();

    }


    @Override
    public Application findByName(String name){
        return applicationRepository.findApplicationByName(name);

    }

    @Override
    public ApplicationVO save(Application application){
        Application salvo = applicationRepository.save(application);
        return MapperUtils.instance().map(salvo,ApplicationVO.class);

    }



    @Override
    public Long deleteById(Long id){
        applicationRepository.deleteById(id);
        return id;
    }

    @Override
    public Application delete(Application application){
        applicationRepository.delete(application);
        return application;
    }



}

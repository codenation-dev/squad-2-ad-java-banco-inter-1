package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Status;
import br.com.centralerros.application.domain.repository.StatusRepository;
import br.com.centralerros.application.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;


    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}

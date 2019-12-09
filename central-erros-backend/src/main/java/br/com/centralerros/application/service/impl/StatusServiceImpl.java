package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Role;
import br.com.centralerros.application.domain.entity.Status;
import br.com.centralerros.application.domain.repository.RoleRepository;
import br.com.centralerros.application.domain.repository.StatusRepository;
import br.com.centralerros.application.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    @Override
    public Status findByName(String name) {
        return statusRepository.findStatusByName(name);
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status delete(Status status) {
        statusRepository.delete(status);
        return status;
    }
}

package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    List<Status> findAll();
    Optional<Status> findById(Long id);
    Status findByName(String name);
    Status save(Status status);
    Status delete(Status status);
}

package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> findAll();
    Status findById(int id);
    Status findByName(String name);

}

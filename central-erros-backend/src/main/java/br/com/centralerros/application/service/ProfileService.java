package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> findAll();
    Profile findById(int id);
    Profile findByName(String name);
}

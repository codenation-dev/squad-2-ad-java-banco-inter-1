package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
}

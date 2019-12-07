package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Role;
import br.com.centralerros.application.domain.repository.RoleRepository;
import br.com.centralerros.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}

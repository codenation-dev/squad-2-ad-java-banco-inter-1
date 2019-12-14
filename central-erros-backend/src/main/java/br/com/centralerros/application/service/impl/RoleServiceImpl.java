package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Role;
import br.com.centralerros.application.domain.enumerables.RoleEnum;
import br.com.centralerros.application.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> findAll() {
        return Arrays.asList(RoleEnum.values())
                .stream()
                .map(e -> new Role(e.getValue(), e.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Role findById(int id) {

        return Arrays.asList(
                RoleEnum.values())
                .stream()
                .filter( r -> r.getValue() == id)
                .map(r -> new Role(id, r.toString()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Role findByName(String name) {
        return Arrays.asList(
                RoleEnum.values())
                .stream()
                .filter( r -> r.toString() == name)
                .map(r -> new Role(r.getValue(), name))
                .findFirst()
                .orElse(null);
    }
}

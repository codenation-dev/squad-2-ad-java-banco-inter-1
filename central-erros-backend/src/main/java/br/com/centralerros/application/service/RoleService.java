package br.com.centralerros.application.service;

    /*- Level
findAll
findById
findByName
save
update
delete (safe delete)*/

import br.com.centralerros.application.domain.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role findByName(String name);
    Role save(Role role);
    // Role update(Role role);
    Role delete(Role role);
}

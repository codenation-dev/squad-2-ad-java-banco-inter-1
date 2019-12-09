package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Transactional
    Role findRoleByName (@Param("name") String name);
}

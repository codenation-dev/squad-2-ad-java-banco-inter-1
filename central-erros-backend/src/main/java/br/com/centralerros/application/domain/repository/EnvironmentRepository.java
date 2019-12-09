package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {

    @Transactional
    Environment findEnviromentByName (@Param("name") String name);

}

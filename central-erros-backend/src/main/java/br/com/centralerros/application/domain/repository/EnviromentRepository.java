package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Enviroment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EnviromentRepository extends JpaRepository<Enviroment, Long> {

    @Transactional
    Enviroment findEnviromentByName (@Param("name") String name);

}

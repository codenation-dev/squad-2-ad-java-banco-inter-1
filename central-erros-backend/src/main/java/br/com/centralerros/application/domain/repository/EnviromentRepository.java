package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Enviroment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnviromentRepository extends JpaRepository<Enviroment, Long> {
}

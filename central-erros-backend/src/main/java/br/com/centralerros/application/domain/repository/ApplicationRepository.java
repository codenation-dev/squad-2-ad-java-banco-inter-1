package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Transactional
    Application findApplicationByName(@Param("name") String name);
}

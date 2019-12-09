package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Transactional
    Status findStatusByName (@Param("name") String name);
}

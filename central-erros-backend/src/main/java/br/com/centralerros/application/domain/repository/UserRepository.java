package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    User findByEmail(@Param("email") String email);

    @Transactional
    User findUserByEmailAndPassword (@Param("email") String email,
                                     @Param("password") String password);

}

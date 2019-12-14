package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Transactional
    @Query(value = "SELECT u.* FROM centralerros.user u, centralerros.user_application ua, centralerros.application a\n" +
            "WHERE u.id = ua.user_id\n" +
            "AND a.id = ua.application_id\n" +
            "AND a.name = :name",nativeQuery = true)
    User findByApplication (@Param("name") String name);

    @Transactional
    User findUserByProfile (@Param("profile") String profile);

    @Transactional
    User findUserByName (@Param("name") String name);
}

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
    @Query(value = "SELECT u.* FROM user u WHERE u.email = :email LIMIT 1", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Transactional
    User findUserByEmailAndPassword(@Param("email") String email,
                                    @Param("password") String password);

    @Transactional
    @Query(value = "SELECT u.* FROM centralerros.user u, centralerros.user_application ua, centralerros.application a " +
            "WHERE u.id = ua.user_id " +
            "AND a.id = ua.application_id " +
            "AND a.name = :name",nativeQuery = true)
    User findByApplication(@Param("name") String name);

    @Transactional
    User findUserByName(@Param("name") String name);

}

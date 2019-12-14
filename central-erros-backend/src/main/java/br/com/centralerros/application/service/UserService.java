package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    User findByEmail(String name);
    Optional<User> findById(Long id);
    User findByEmailEPassword(String email, String password);
    User findByApplication(String name);
    User findByProfile(String profile);
    User findByName(String name);
    List<User> findAll();
    User delete(User user);
    Long delete(Long id);

}

package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.User;

public interface UserService {
    User save(User user);
    User findByEmail(String name);
}

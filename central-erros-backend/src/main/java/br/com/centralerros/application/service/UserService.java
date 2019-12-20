package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.UserVO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserVO save(User user);
    User findByEmail(String email);
    User findByEmailLoginSecurity(String email);
    Optional<User> findById(Long id);
    UserVO findByIdVO(Long id);
    User findByEmailEPassword(String email, String password);
    User findByApplication(String name);
    User findByName(String name);
    List<User> findAll();
    List<UserVO> findAllVO();
    void delete(User user);
    void delete(Long id);
    UserVO findByEmailVO(String email);

}

package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.repository.UserRepository;
import br.com.centralerros.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);

    }

    @Override
    public User findByEmailEPassword(String email, String password){
        return userRepository.findUserByEmailAndPassword(email,password);
    }

    @Override
    public User findByApplication(String name){
        return userRepository.findByApplication(name);

    }

    @Override
    public User findByProfile (String profile) {
        return userRepository.findUserByProfile(profile);
    }

    @Override
    public User findByName (String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();

    }





}

package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.repository.UserRepository;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.exception.IncompleteFieldsException;
import br.com.centralerros.application.exception.NotFoundObjectException;
import br.com.centralerros.application.exception.NullObjectException;
import br.com.centralerros.application.service.UserService;
import br.com.centralerros.application.utils.MapperUtils;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserVO save(User user) {
        //nao pode este validar?, pois o update tambem passa aqui
        validarSalvarUsuario(user);

        User userSave = userRepository.save(user);
        UserVO userVO = MapperUtils.instance().map(userSave, UserVO.class);
        return userVO;

    }


    @Override
    public Long delete(Long id) {
        validarDadosDeletarUsuario(id);
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User delete(User user) {
        validarUsuario(user);

        userRepository.delete(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserVO findByEmailVO(String email) {
        User user = userRepository.findByEmail(email);
        UserVO uservo = MapperUtils.instance().map(user, UserVO.class);
        return uservo;
    }

    @Override
    public User findByEmailLoginSecurity(String email) {
        User user = findByEmail(email);

        if (user != null) {
            user.setLast_login(LocalDateTime.now());
            save(user);
        }

        return user;
    }


    @Override
    public Optional<User> findById(Long id) {
        validarUsuario(id);
        return userRepository.findById(id);
    }

    @Override
    public User findByEmailEPassword(String email, String password) {
        validarUsuario(email, password);
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User findByApplication(String name) {
        return userRepository.findByApplication(name);

    }


    @Override
    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }


    /*VALIDACOES*/
    private void validarApplicationName(String name) {
        if (Utils.isNullOrWhiteSpace(name)) {
            throw new IncompleteFieldsException("Field NAME not defined or null in Application");
        }
    }
    private void validarSalvarUsuario(User user) {

        if (Utils.isNullOrWhiteSpace(user.getName())) {
            throw new IncompleteFieldsException("Field NAME not defined or null in User");
        } else if (Utils.isNullOrWhiteSpace(user.getPassword())) {
            throw new IncompleteFieldsException("Field PASSWORD not defined or null in User");
        } else if (Utils.isNullOrWhiteSpace(user.getEmail())) {
            throw new IncompleteFieldsException("Field EMAIL not defined or null in User");
        }


    }

    private void validarDadosDeletarUsuario(Long id) {
        if (id == null) {
            throw new NullObjectException("User id was null");
        }
        Optional<User> user = findById(id);
        if (!user.isPresent()) {
            throw new NotFoundObjectException(String.format("User with id: %s was not found", id));
        }
    }

    private void validarUsuario(User user) {
        if (user == null) {
            throw new NullObjectException("User object cannot be null");
        } else if (user.getId() == null) {
            throw new IncompleteFieldsException("Field id not defined or null in User");
        }
    }

    private void validarUsuario(Long id) {
        if (id == null) {
            throw new IncompleteFieldsException("Field ID not defined or null in User");
        }
    }

    private void validarUsuario(String email, String password) {
        if (Utils.isNullOrWhiteSpace(email)) {
            throw new IncompleteFieldsException("Field EMAIL not defined or null in User");
        } else if (Utils.isNullOrWhiteSpace(password)) {
            throw new IncompleteFieldsException("Field PASSWORD not defined or null in User");
        }
    }


}

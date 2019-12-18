package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
@Sql("/user_service_test.sql")
public class UserServiceTest {

    private static final String name_user = "Guilherme";
    private static final String password = "senha";
    private static final String email = "email@email.com";

    @Autowired
    UserServiceImpl userService;

    @Test
    @Transactional
    public void whenSave() {

        User user = getUser();

        User result =userService.save(user);
        System.out.println(result);
        assertUser(result);

    }

    @Test
    @Transactional
    public void whenFindById() {

        Optional<User> optResult = userService.findById(Long.valueOf(1));
        assertThat(optResult.isPresent(),equalTo(true));

    }

    @Test
    @Transactional
    public void whenFindByName(){

        User result = userService.findByName(name_user);
        assertEquals(result.getName(),name_user);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<User> result = userService.findAll();
        assertThat(result,hasSize(1));
    }

    private void assertUser(User result){
        assertThat(result.getId(),notNullValue());
        assertThat(result.getName(),equalTo(name_user));
        assertThat(result.getPassword(),equalTo(password));
        assertThat(result.getEmail(),equalTo(email));


    }

    private User getUser (){

        User user = new User();

        user.setName(name_user);
        user.setEmail(email);
        user.setPassword(password);


        return user;
    }



 }

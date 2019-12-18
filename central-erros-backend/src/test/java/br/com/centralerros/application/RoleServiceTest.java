package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Role;
import br.com.centralerros.application.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    @Transactional
    public void whenFindByName(){


        String name = "ADMINISTRATOR";
        Role result = roleService.findByName("ADMINISTRATOR");

        assertEquals(result.getName(),name);

        name = "APPLICATION";
        result = roleService.findByName("APPLICATION");

        assertEquals(result.getName(),name);

        name = "DEVELOPER";
        result = roleService.findByName("DEVELOPER");

        assertEquals(result.getName(),name);
    }

    @Test
    @Transactional
    public void whenFindById(){

        String name = "ADMINISTRATOR";
        Role optResult = roleService.findById(1);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),1);

        name = "APPLICATION";
        optResult = roleService.findById(2);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),2);

        name = "DEVELOPER";
        optResult = roleService.findById(3);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),3);



    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Role> result = roleService.findAll();

        assertThat(result,hasSize(3));
    }

}

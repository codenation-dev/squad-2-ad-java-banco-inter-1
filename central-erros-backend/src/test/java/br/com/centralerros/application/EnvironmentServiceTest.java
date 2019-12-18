package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.service.impl.EnvironmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class EnvironmentServiceTest {


    @Autowired
    EnvironmentServiceImpl environmentService;

    @Test
    @Transactional
    public void whenFindById(){

        String name = "DEVELOPMENT";
        Environment optResult = environmentService.findById(1);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),1);

        name = "TESTING";
        optResult = environmentService.findById(2);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),2);

        name = "ACCEPTANCE";
        optResult = environmentService.findById(3);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),3);

        name = "PRODUCTION";
        optResult = environmentService.findById(4);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),4);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Environment> result = environmentService.findAll();

        assertThat(result,hasSize(4));
    }

    @Test
    @Transactional
    public void whenFindByName(){

        String name = "DEVELOPMENT";
        Environment result = environmentService.findByName("DEVELOPMENT");

        assertEquals(result.getName(),name);

        name = "TESTING";
        result = environmentService.findByName("TESTING");

        assertEquals(result.getName(),name);

        name = "ACCEPTANCE";
        result = environmentService.findByName("ACCEPTANCE");

        assertEquals(result.getName(),name);

        name = "PRODUCTION";
        result = environmentService.findByName("PRODUCTION");

        assertEquals(result.getName(),name);

    }


}

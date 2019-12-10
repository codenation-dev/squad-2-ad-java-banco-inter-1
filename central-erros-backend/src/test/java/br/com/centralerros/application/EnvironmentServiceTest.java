package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.service.EnvironmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class EnvironmentServiceTest {

    @Autowired
    EnvironmentService environmentService;

    @Test
    @Transactional
    public void whenFindById(){

        Environment optResult = environmentService.findById(1);
        assertThat(optResult != null, equalTo(true));

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Environment> result = environmentService.findAll();

        assertThat(result,hasSize(3));
    }

    @Test
    @Transactional
    public void whenFindByName(){

        String name = "Produção";
        Environment result = environmentService.findByName("Produção");

        assertEquals(result,name);
    }




}

package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Status;
import br.com.centralerros.application.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class StatusServiceTest {
/*
    @Autowired
    StatusServiceImpl statusService;

    @Test
    @Transactional
    public void whenFindById(){

        String name = "OPEN";
        Status optResult = statusService.findById(1);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),1);

        name = "VERIFYING";
        optResult = statusService.findById(2);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),2);

        name = "CLOSED";
        optResult = statusService.findById(3);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),3);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Status> result = statusService.findAll();

        assertThat(result,hasSize(3));
    }

    @Test
    @Transactional
    public void whenFindByName(){

        String name = "OPEN";
        Status result = statusService.findByName("OPEN");

        assertEquals(result.getName(),name);

        name = "VERIFYING";
        result = statusService.findByName("VERIFYING");

        assertEquals(result.getName(),name);

        name = "CLOSED";
        result = statusService.findByName("CLOSED");

        assertEquals(result.getName(),name);

    }
*/



}

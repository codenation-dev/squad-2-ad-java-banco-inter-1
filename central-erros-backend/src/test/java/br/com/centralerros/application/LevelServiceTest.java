package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.service.impl.LevelServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class LevelServiceTest {

    @Autowired
    LevelServiceImpl levelService;

    @Test
    @Transactional
    public void whenFindById(){


        String name = "DEBUG";
        Level optResult = levelService.findById(1);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),1);

        name = "INFO";
        optResult = levelService.findById(2);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),2);

        name = "WARNING";
        optResult = levelService.findById(3);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),3);

        name = "ERROR";
        optResult = levelService.findById(4);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),4);


        name = "FATAL";
        optResult = levelService.findById(5);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),5);

    }


    @Test
    @Transactional
    public void whenFindAll(){

        List<Level> result = levelService.findAll();

        assertThat(result,hasSize(6));
    }

    @Test
    @Transactional
    public void whenFindByName(){

        String name = "DEBUG";
        Level result = levelService.findByName("DEBUG");

        assertEquals(result.getName(),name);

        name = "INFO";
        result = levelService.findByName("INFO");

        assertEquals(result.getName(),name);

        name = "WARNING";
        result = levelService.findByName("WARNING");

        assertEquals(result.getName(),name);

        name = "ERROR";
        result = levelService.findByName("ERROR");

        assertEquals(result.getName(),name);

        name = "FATAL";
        result = levelService.findByName("FATAL");

        assertEquals(result.getName(),name);


    }

}

package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class CategoryServicesTest {

    @Autowired
    CategoryServiceImpl categoryService;

    /*@Test
    @Transactional
    public void whenFindById(){

        String name = "APPLICATION";
        Category optResult = categoryService.findById(1);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),1);

        name = "BUSINESS";
        optResult = categoryService.findById(2);

        assertEquals(optResult.getName(),name);
        assertEquals(optResult.getId(),2);

    }

    @Test
    @Transactional
    public void whenFindByName(){

        String name = "APPLICATION";
        Category result = categoryService.findByName("APPLICATION");

        assertEquals(result.getName(),name);

        name = "BUSINESS";
        result = categoryService.findByName("BUSINESS");

        assertEquals(result.getName(),name);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Category> result = categoryService.findAll();

        assertThat(result,hasSize(2));
    }*/

}

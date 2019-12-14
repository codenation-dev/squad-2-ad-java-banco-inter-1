package br.com.centralerros.application;

import br.com.centralerros.application.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleTest {
    @Autowired
    RoleServiceImpl roleService;
    @Test
    public void findByName(){
        String name = "Teste1";
        //roleService.findByName(name);
    }

    @Test
    public void findById(){
        Long id = 1L;
        //roleService.findById(id);
    }
}

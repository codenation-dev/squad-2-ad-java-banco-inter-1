package br.com.centralerros.application;

import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import br.com.centralerros.application.service.impl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class EventTest {

    @Autowired
    RoleServiceImpl roleService;


    @Autowired
    EventServiceImpl eventService;

    @Test
    public void insert_event() {
        EventVO enventVo = EventVO.builder().name("First Erro")
                .level(LevelEnum.DEBUG)
                .category(CategoryEnum.APPLICATION)
                .environment(EnvironmentEnum.DEVELOPMENT)
                .status(StatusEnum.OPEN)
                .description("Ocorreu no Windows 98 ao clicar no iniciar")
                .source("....conteudo.....")
                .details("Linha 12323 arquivo win98.cpp").build();

        eventService.save(enventVo);
    }

    @Test
    public void find_event_by_date() {
        LocalDateTime dateTime = LocalDateTime.now();
        //eventService.findEventByCreatedAt(dateTime);
    }

    @Test
    public void find_event_by_level() {
        //eventService.findByLevel("");

    }

    @Test
    public void find_event_by_category() {
        //eventService.findByCategory()
    }

    @Test
    public void find_event_by_enviroment() {
        //eventService.findByEnvironment()
    }

    @Test
    public void find_all() {
        //List<Event> events = eventService.findAll();
        //Assert.assertNotNull();
    }

    @Test
    public void drop_event() {
        //eventService.delete(1L);
    }
}

package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.enumerables.*;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
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
import static org.junit.Assert.assertThat;

@SpringBootTest
@Sql("/user_service_test.sql")
public class EventServiceTest {

    private static final String description = "Texto description";
    private static final String source = "Texto source";
    private static final String details = "Texto details";
    private static final StatusEnum status = StatusEnum.OPEN;
    private static final EnvironmentEnum environment = EnvironmentEnum.DEVELOPMENT;
    private static final LevelEnum level = LevelEnum.DEBUG;
    private static final CategoryEnum category = CategoryEnum.APPLICATION;


    private static final String name_app = "Unix";
    private static final String name_user = "Guilherme";
    private static final String password = "senha";
    private static final String email = "email@email.com";


    @Autowired
    EventServiceImpl eventService;

    @Test
    @Transactional
    public void whenSave() {

        Event event = getEvent();
        EventVO result = eventService.save(event);

        assertEvent(result);

    }

    @Test
    @Transactional
    public void whenFindById() {

        Optional<Event> optResult = eventService.findById(Long.valueOf(1));
        assertThat(optResult.isPresent(), equalTo(true));

    }

    @Test
    @Transactional
    public void whenFindAll() {

        List<EventVO> result = eventService.findAll();
        assertThat(result, hasSize(1));
    }


    private void assertEvent(EventVO result) {
        assertThat(result.getId(), notNullValue());
        assertThat(result.getDescription(), equalTo(description));
        assertThat(result.getSource(), equalTo(source));
        assertThat(result.getDetails(), equalTo(details));
        assertThat(result.getStatus(), equalTo(status));
        assertThat(result.getEnvironment(), equalTo(environment));
        assertThat(result.getLevel(), equalTo(level));
        assertThat(result.getCategory(), equalTo(category));


    }


    private Event getEvent() {

        Event event = new Event();

        event.setId(Long.valueOf(1));
        event.setDescription(description);
        event.setSource(source);
        event.setDetails(details);
        event.setStatus(status);
        event.setEnvironment(environment);
        event.setLevel(level);
        event.setCategory(category);
        event.setUser(getUser());
        event.setApplication(getApplication());
        return event;
    }

    private User getUser() {
        User user = new User();

        user.setId(Long.valueOf(1));
        user.setName(name_user);
        user.setEmail(email);
        user.setPassword(password);


        return user;
    }

    private Application getApplication() {

        Application application = new Application();

        application.setId(Long.valueOf(1));

        application.setName(name_app);
        return application;
    }


}

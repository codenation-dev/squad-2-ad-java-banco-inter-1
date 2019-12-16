package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

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

    private static final String name_app = "Unix";

    private static final String name_user = "Guilherme";
    private static final String password = "senha";
    private static final String email = "email";



    @Autowired
    EventServiceImpl eventService;

    @Test
    @Transactional
    public void whenSave() {

        Event event = getEvent();
        System.out.println("APLICAÇÃO DADOS"+getApplication());
        EventVO result =eventService.save(event);

        assertEvent(result);

    }

    @Test
    @Transactional
    public void whenFindById() {

        EventVO optResult = eventService.findById(Long.valueOf(1));
        assertThat(optResult.getDetails(),equalTo(details));

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<EventVO> result = eventService.findAll();
        assertThat(result,hasSize(1));
    }



    private void assertEvent(EventVO result){
        assertThat(result.getId(),notNullValue());
        assertThat(result.getDescription(),equalTo(description));
        assertThat(result.getSource(),equalTo(source));
        assertThat(result.getDetails(),equalTo(details));


    }


    private Event getEvent (){

        Event event = new Event();

        event.setDescription(description);
        event.setSource(source);
        event.setDetails(details);
        //event.setStatus(status);
        event.setUser(getUser());
        event.setApplication(getApplication());
        return event;
    }

    private User getUser (){

        User user = new User();

        user.setName(name_user);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    private Application getApplication (){

        Application application = new Application();

        application.setId(Long.valueOf(1));

        application.setName(name_app);
        return application;
    }


}

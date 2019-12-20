package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.RoleEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import br.com.centralerros.application.domain.vo.ApplicationVO;
import br.com.centralerros.application.domain.vo.CategoryVO;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import br.com.centralerros.application.utils.MapperUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@SpringBootTest
//@Sql("/user_service_test.sql")
public class EventServiceTest {

    private static final Long id = Long.valueOf("101");
    private static final String description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida";
    private static final String source = "lobortis.";
    private static final String details = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestib";
    private static final StatusEnum status = StatusEnum.valueOf(1);
    private static final EnvironmentEnum environment = EnvironmentEnum.valueOf(2);
    private static final LevelEnum level = LevelEnum.valueOf(4);

    private static final RoleEnum roleUser = RoleEnum.valueOf(1);

    private static final UserVO user  = UserVO.builder().id((long) 1).name("user").role(roleUser).email("user@email.com.br").build();
    private static final ApplicationVO application = ApplicationVO.builder().id((long) 3).name("Squad2JavaApplication").build();
    private static final CategoryVO category = CategoryVO.builder().id((long) 3).name("SumitError").application(application).build();

    @Autowired
    EventServiceImpl eventService;

    @Test
    @Transactional
    public void whenSave() {

        EventVO event = getEvent();
        Event result = MapperUtils.instance().map(event, Event.class);

        EventVO salvo = eventService.save(result);

        System.out.println("RESULTADO SALVO: "+salvo);
        assertEvent(salvo);

    }

    @Test
    @Transactional
    public void whenFindById() {

        Optional<Event> optResult = eventService.findById(Long.valueOf(101));
        assertThat(optResult.isPresent(), equalTo(true));

    }

    @Test
    @Transactional
    public void whenFindAll() {

        List<EventVO> result = eventService.findAll();
        assertThat(result, hasSize(100));
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
        assertThat(result.getUser(), equalTo(user));
        assertThat(result.getApplication(), equalTo(application));

    }


    private EventVO getEvent() {

        EventVO event = new EventVO();

        event.setId(Long.valueOf(101));
        event.setDescription(description);
        event.setSource(source);
        event.setDetails(details);
        event.setStatus(status);
        event.setEnvironment(environment);
        event.setLevel(level);
        event.setCategory(category);
        event.setUser(user);
        event.setApplication(application);
        return event;
    }



}

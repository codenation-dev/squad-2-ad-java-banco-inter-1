package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.vo.ApplicationVO;
import br.com.centralerros.application.service.impl.ApplicationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@SpringBootTest
//@Sql("/user_service_test.sql")
public class ApplicationServiceTest {

    private static final String NAME = "CodenationApplication";

    @Autowired
    private ApplicationServiceImpl applicationService;

    @Test
    @Transactional
    public void whenSave() {

        Application application = getApplication();

        ApplicationVO result =applicationService.save(application);
        assertApplication(result);

    }

    @Test
    @Transactional
    public void whenFindById() {

        Optional<Application> optResult = applicationService.findById(Long.valueOf(1));
        assertThat(optResult.isPresent(),equalTo(true));

    }

    @Test
    @Transactional
    public void whenFindByName(){

        Application result = applicationService.findByName(NAME);
        assertEquals(result.getName(),NAME);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<Application> result = applicationService.findAll();
        assertThat(result,hasSize(3));
    }

    private void assertApplication(ApplicationVO result){
        assertThat(result.getId(),notNullValue());
        assertThat(result.getName(),equalTo(NAME));

    }

    private Application getApplication (){

        Application application = new Application();

        application.setName(NAME);
        return application;
    }
}

package br.com.centralerros.application;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.vo.ApplicationVO;
import br.com.centralerros.application.domain.vo.CategoryVO;
import br.com.centralerros.application.service.impl.CategoryServiceImpl;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class CategoryServicesTest {

    private static final String name = "CreditCardError";
    private static final String name_app = "CodenationApplication";



    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    @Transactional
    public void whenSave() {

        CategoryVO category = getCategory();

        Category result = MapperUtils.instance().map(category, Category.class);
        CategoryVO savo = categoryService.save(result);

        assertCategory(savo);

    }

    @Test
    @Transactional
    public void whenFindById() {

        Optional<Category> optResult = categoryService.findById(Long.valueOf(1));
        assertThat(optResult.isPresent(),equalTo(true));

    }
    @Test
    @Transactional
    public void whenFindByName(){

        Category result = categoryService.findByName(name);
        assertEquals(result.getName(),name);

    }

    @Test
    @Transactional
    public void whenFindAll(){

        List<CategoryVO> result = categoryService.findAll();
        assertThat(result,hasSize(3));
    }

    private void assertCategory(CategoryVO result){
        assertThat(result.getId(),notNullValue());
        assertThat(result.getName(),equalTo(name));
        assertThat(result.getApplication(),equalTo(getApplication()));


    }


    private CategoryVO getCategory (){

        CategoryVO category = new CategoryVO();

        category.setId(Long.valueOf(1));
        category.setName(name);
        category.setApplication(getApplication());
        return category;
    }

    private ApplicationVO getApplication() {

        ApplicationVO application = new ApplicationVO();

        application.setId(Long.valueOf(1));
        application.setName(name_app);
       return application;
    }

}

package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    List<CategoryVO> findAll();
    Category findById(Long id);
    Category findByIdEApplicationId(Long id, Long applicationId);
    CategoryVO findByNameVo(String name);
    CategoryVO findByNameVoEApplicationId(String name, Long applicationId);
    Category findByNameEApplicationId(String name, Long applicationId);
    Category findByName(String name);
    Category findByNameApplicationId(String name, Long applicationId);
    CategoryVO save(Category category);
    Category saveComum(Category category);
}

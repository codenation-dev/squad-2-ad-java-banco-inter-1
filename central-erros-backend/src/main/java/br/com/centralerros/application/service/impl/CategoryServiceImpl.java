package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.domain.repository.CategoryRepository;
import br.com.centralerros.application.domain.vo.CategoryVO;
import br.com.centralerros.application.service.CategoryService;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryVO> findAll() {
        List<Category> categorias = categoryRepository.findAll();
        List<CategoryVO> categoriasVO = new ArrayList<>();

        if (categorias != null && !categorias.isEmpty()) {
            categoriasVO = categorias.stream().map(category -> Utils.map(category, CategoryVO.class)).collect(Collectors.toList());
        }
        return categoriasVO;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByIdEApplicationId(Long id, Long applicationId) {
        return categoryRepository.findByIdEApplication(id, applicationId);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findByNameApplicationId(String name, Long applicationId) {
        return categoryRepository.findByNameEApplication(name, applicationId);
    }

    @Override
    public CategoryVO findByNameVo(String name) {
        Category category = categoryRepository.findByName(name);
        return Utils.map(category, CategoryVO.class);
    }

    @Override
    public CategoryVO findByNameVoEApplicationId(String name, Long applicationId) {
        Category category = categoryRepository.findByNameEApplication(name, applicationId);
        return Utils.map(category, CategoryVO.class);
    }

    @Override
    public Category findByNameEApplicationId(String name, Long applicationId) {
        return categoryRepository.findByNameEApplication(name, applicationId);
    }

    @Override
    public CategoryVO save(Category category) {
        Category categorySaved = categoryRepository.save(category);
        return Utils.map(categorySaved, CategoryVO.class);
    }

    @Override
    public Category saveComum(Category category) {
        return categoryRepository.save(category);
    }


}

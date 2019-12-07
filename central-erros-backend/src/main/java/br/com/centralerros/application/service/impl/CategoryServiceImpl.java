package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.repository.CategoryRepository;
import br.com.centralerros.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

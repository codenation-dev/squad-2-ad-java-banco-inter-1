package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category findByName(String name);
}

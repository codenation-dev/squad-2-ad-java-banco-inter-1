package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        return Arrays.asList(CategoryEnum.values())
                .stream()
                .map(c -> new Category(c.getValue(), c.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(int id) {

        return Arrays.asList(
                CategoryEnum.values())
                .stream()
                .filter( c -> c.getValue() == id)
                .map(c -> new Category(id, c.toString()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return Arrays.asList(
                CategoryEnum.values())
                .stream()
                .filter( c -> c.toString() == name)
                .map(c -> new Category(c.getValue(), name))
                .findFirst()
                .orElse(null);
    }
}

package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
}

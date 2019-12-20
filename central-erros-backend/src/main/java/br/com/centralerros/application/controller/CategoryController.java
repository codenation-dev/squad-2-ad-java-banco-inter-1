package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.vo.IdNameVO;
import br.com.centralerros.application.service.CategoryService;
import br.com.centralerros.application.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController extends BasicController {
    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @PostMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/name/{id}")
    public ResponseEntity finByName(@PathVariable String name) {
        return ResponseEntity.ok(categoryService.findByName(name));
    }
}

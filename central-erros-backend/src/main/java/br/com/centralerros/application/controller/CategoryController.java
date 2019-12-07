package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.vo.CategoryVO;
import br.com.centralerros.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController extends BasicController {
    @Autowired
    CategoryService categoryService;

    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                utils.listMap(
                        categoryService.findAll(),
                        CategoryVO.class)
        );
    }

}

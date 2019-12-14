package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.vo.IdNameVO;
import br.com.centralerros.application.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/category")
public class LevelController extends BasicController {
    @Autowired
    LevelService levelService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                utils.map(
                        levelService.findAll(),
                        IdNameVO.class
                )
        );
    }
}

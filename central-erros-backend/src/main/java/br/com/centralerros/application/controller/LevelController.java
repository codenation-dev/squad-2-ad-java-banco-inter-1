package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.vo.LevelVO;
import br.com.centralerros.application.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/level")
public class LevelController extends BasicController {
    @Autowired
    LevelService levelService;

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
            utils.listMap(levelService.findAll(), LevelVO.class)
        );
    }
}

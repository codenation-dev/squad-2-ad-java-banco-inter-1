package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.vo.IdNameVO;
import br.com.centralerros.application.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")

public class StatusController extends BasicController{
    @Autowired
    StatusService statusService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                utils.listMap(
                        statusService.findAll(),
                        IdNameVO.class
                )
        );
    }
}

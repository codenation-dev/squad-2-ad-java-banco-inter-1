package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.vo.IdNameVO;
import br.com.centralerros.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends BasicController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                utils.listMap(
                        roleService.findAll(),
                        IdNameVO.class
                )
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") int id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity findByAll(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.ok(roleService.findByName(name));
    }

}

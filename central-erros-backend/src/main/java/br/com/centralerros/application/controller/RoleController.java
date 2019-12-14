package br.com.centralerros.application.controller;

import br.com.centralerros.application.service.RoleService;
import br.com.centralerros.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    protected RoleService roleService;

    @GetMapping("/findById")
    public ResponseEntity findById(@RequestBody Long id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @GetMapping("/findByName")
    public ResponseEntity findByName(@RequestBody String name){
        return ResponseEntity.ok(roleService.findByName(name));
    }
}

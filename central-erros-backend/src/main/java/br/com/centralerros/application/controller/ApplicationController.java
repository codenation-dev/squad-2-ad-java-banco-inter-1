package br.com.centralerros.application.controller;

import br.com.centralerros.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/findByID/{id}")
    public ResponseEntity findByID(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.findById(id));
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.ok(applicationService.findByName(name));
    }
}

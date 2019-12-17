package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.service.impl.ApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

    @Autowired
    ApplicationServiceImpl applicationService;


    @PostMapping("")
    public ResponseEntity save(@RequestBody Application application){
        return ResponseEntity.ok(applicationService.save(application));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.deleteById(id));
    }

    @DeleteMapping("")
    public ResponseEntity delete(@RequestBody Application application){
        return ResponseEntity.ok(applicationService.delete(application));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity findByAll(){
        return ResponseEntity.ok(applicationService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.ok(applicationService.findByName(name));
    }


}

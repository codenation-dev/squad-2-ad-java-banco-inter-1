package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    EventServiceImpl eventService;

    //Falta testar
    //Todos os métodos de busca devem ser GET ?(Acho melhor alguns não serem) //analisar

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity findByCategory(@PathVariable String category) {
        return ResponseEntity.ok(eventService.findByCategory(category));
    }

    @GetMapping("/findByLevel/{level}")
    public ResponseEntity findByLevel(@PathVariable String level) {
        return ResponseEntity.ok(eventService.findByLevel(level));
    }

    @GetMapping("/findByCreatedAt/{created_at}")
    public ResponseEntity findByDataCreated(@PathVariable("created_at") LocalDateTime createdAt) {
        return ResponseEntity.ok(eventService.findEventByCreatedAt(createdAt));
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity findByID(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody EventVO eventVO){
        return ResponseEntity.ok(eventService.save(eventVO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(eventService.delete(id));
    }
}

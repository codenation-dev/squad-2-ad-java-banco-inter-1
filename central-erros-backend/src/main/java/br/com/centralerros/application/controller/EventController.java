package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
public class EventController extends BasicController {

    @Autowired
    EventServiceImpl eventService;

    @PostMapping("")
    public ResponseEntity save(@RequestBody Event event){
        //event.setUser(user);

        return ResponseEntity.ok(eventService.save(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.delete(id));
    }

    @DeleteMapping("")
    public ResponseEntity deleteEvent(@RequestBody Event event){
        return ResponseEntity.ok(eventService.delete(event));
    }

    @GetMapping("")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/{user}")
    public ResponseEntity findAllFromUser(@PathVariable("user") User user){
        return ResponseEntity.ok(eventService.findAllFromUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity findAllFromUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.findAllFromUserById(id));
    }

    @PostMapping("/filter")
    public ResponseEntity findEvent(@RequestBody EventFilterDto filter){
        return ResponseEntity.ok(utils.listMap(eventService.findEvents(filter), EventVO.class));
    }
}

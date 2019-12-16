package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
public class EventController extends BasicController {

    @Autowired
    EventServiceImpl eventService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Event event){
        User user = utils.getLoggedUser();
        event.setUser(user);
        return ResponseEntity.ok(eventService.save(event));
    }

    @GetMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.delete(id));
    }

    @PostMapping("/deleteEvent")
    public ResponseEntity deleteEvent(@RequestBody EventVO eventVO){
        return ResponseEntity.ok(eventService.delete(eventVO));
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }

    @PostMapping("/findAllFromUser")
    public ResponseEntity findAllFromUser(UserVO userVO){
        return ResponseEntity.ok(eventService.findAllFromUser(userVO));
    }

    @PostMapping("/filter")
    public ResponseEntity findEvent(@RequestBody EventFilterDto filter){
        return ResponseEntity.ok(utils.listMap(eventService.findEvents(filter), EventVO.class));
    }



}

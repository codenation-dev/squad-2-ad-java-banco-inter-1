package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.ListaVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController extends BasicController {

    @Autowired
    EventServiceImpl eventService;

    @PostMapping("")
    public ResponseEntity save(@RequestBody Event event) {
        event.setUser(utils.getLoggedUser());
        return validadeRetorno(eventService.save(event));
    }

    @PutMapping
    public ResponseEntity associarUser(@Param("id") Long id, @Param("user_id") Long user_id) {
        return ResponseEntity.ok(eventService.associarUser(id,user_id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventService.delete(id));
    }

    @DeleteMapping("")
    public ResponseEntity deleteEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.delete(event));
    }

    @GetMapping("")
    public ResponseEntity findAll() {
        return validadeRetorno(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return validadeRetorno(eventService.findByIdVO(id));
    }

    @PostMapping("/user")
    public ResponseEntity findAllFromUser(@RequestBody User user) {
        return validadeRetorno(eventService.findAllFromUser(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findAllFromUser(@PathVariable("id") Long id) {
        return validadeRetorno(eventService.findAllFromUserById(id));
    }

    @PostMapping("/filter")
    public ResponseEntity findEvent(@RequestBody EventFilterDto filter) {
        return ResponseEntity.ok(
                ListaVO.builder().filter(filter).items(utils.listMap(
                        eventService.findEvents(filter),
                        EventVO.class))
                        .count(eventService.findEventsCount(filter))
                        .build()
        );
    }

    public ResponseEntity<? extends Object> validadeRetorno(List<Object> list) {
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<? extends Object> validadeRetorno(Object object) {
        if (object != null) {
            return ResponseEntity.ok(object);
        } else {
            return ResponseEntity.ok().build();
        }
    }
}

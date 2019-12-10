package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

   // @Autowired
    //EventServiceImpl eventService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody EventVO eventVO){
        return ResponseEntity.ok(eventService.save(eventVO));
    }
}

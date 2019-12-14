package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.service.impl.EventServiceImpl;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
public class EventController extends BasicController {

    @Autowired
    EventServiceImpl eventService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody EventVO eventVO){
        return ResponseEntity.ok(eventService.save(utils.map(eventVO, Event.class)));
    }

    @PostMapping("/filter")
    public ResponseEntity findEvent(@RequestBody EventFilterDto filter){
        return ResponseEntity.ok(utils.listMap(eventService.findEvents(filter), EventVO.class));
    }

}

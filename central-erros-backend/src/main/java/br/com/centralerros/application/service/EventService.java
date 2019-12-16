package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;

import java.util.List;

public interface EventService {
    List<Event> findEvents(EventFilterDto filter);
    EventVO findById(Long id);
    EventVO save(Event event);
    Long delete(Long id);
    EventVO delete(Event event);
    EventVO delete(EventVO eventVo);
    List<EventVO> findAll();
    List<EventVO> findAllFromUser(UserVO userVO);
}

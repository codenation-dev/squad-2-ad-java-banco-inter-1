package br.com.centralerros.application.service;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findEvents(EventFilterDto filter);
    Optional<Event> findById(Long id);
    EventVO findByIdVO(Long id);
    EventVO save(Event event);
    EventVO delete(Long id);
    EventVO delete(Event event);
    EventVO delete(EventVO eventVo);
    List<EventVO> findAll();
    List<EventVO> findAllFromUser(UserVO userVO);
    List<EventVO> findAllFromUser(User user);
    List<EventVO> findAllFromUserById(Long id);
    EventVO associarUser(Long id, Long user_id);

    int findEventsCount(EventFilterDto filter);
}

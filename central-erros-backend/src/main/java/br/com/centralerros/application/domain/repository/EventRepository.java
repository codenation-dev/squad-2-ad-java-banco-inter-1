package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.EventVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventRepository {
    List<Event> findEvents(EventFilterDto filter);
}


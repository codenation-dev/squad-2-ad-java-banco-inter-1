package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import br.com.centralerros.application.domain.repository.EventRepositoryJpa;
import br.com.centralerros.application.domain.repository.impl.EventRepositoryImpl;
import br.com.centralerros.application.domain.vo.EventVO;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.exception.IncompleteFieldsException;
import br.com.centralerros.application.exception.NotFoundObjectException;
import br.com.centralerros.application.exception.NullObjectException;
import br.com.centralerros.application.service.ApplicationService;
import br.com.centralerros.application.service.EventService;
import br.com.centralerros.application.service.UserService;
import br.com.centralerros.application.utils.MapperUtils;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepositoryImpl eventRepositoryHibernate;

    @Autowired
    EventRepositoryJpa eventRepository;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ApplicationServiceImpl applicationService;


    @Override
    public List<Event> findEvents(EventFilterDto filter) {
        Utils.getLoggedUser();
        return eventRepositoryHibernate.findEvents(filter);
    }


    @Override
    public EventVO findByIdVO(Long id) {
        validarIdRequestUsuario(id);
        Event event = eventRepository.findById(id).orElse(null);
        EventVO eventVO = null;
        if (event != null) {
            eventVO = Utils.map(event, EventVO.class);
        }
        return eventVO;
    }

    @Override
    public Optional<Event> findById(Long id) {
        validarIdRequestUsuario(id);
        return eventRepository.findById(id);
    }


    private void validarUsuarioDatabase(Long userId) {
        if (!userService.findById(userId).isPresent()) {
            throw new NullObjectException("Usuário inexiste");
        }
    }

    private void validarEventoDatabase(Long eventId) {
        if (!eventRepository.findById(eventId).isPresent()) {
            throw new NullObjectException("Evento inexiste");
        }
    }

    @Override
    public EventVO associarUser(Long id, Long user_id) {

        validarIdRequestEvent(id);
        validarIdRequestUsuario(user_id);
        validarUsuarioDatabase(user_id);
        validarEventoDatabase(id);

        eventRepository.findEventByIdAndUpdateUserId(id, user_id);

        Event event = eventRepository.findById(id).orElse(null);
        EventVO eventVO = null;
        if (event != null) {
            eventVO = MapperUtils.instance().map(event, EventVO.class);
        }
        return eventVO;
    }

    @Override
    public EventVO save(Event event) {
        validarDadosSalvarEvento(event);

        if (event.getStatus() == null) {
            event.setStatus(StatusEnum.OPEN);
        }

        Category category = null;
        Long applicationId = event.getApplication().getId();
        if (event.getCategory() != null) {
            if (event.getCategory().getId() != null && event.getCategory().getId() != 0) {
                category = categoryService.findByIdEApplicationId(event.getCategory().getId(), applicationId);
            }
            if (category == null && !Utils.isNullOrWhiteSpace(event.getCategory().getName())) {
                category = categoryService.findByNameEApplicationId(event.getCategory().getName(), applicationId);
            }

            if (category == null) {

                Category newCategory = new Category();
                newCategory.setName((event.getCategory().getName()));
                newCategory.setApplication(applicationService.findById(applicationId).get());

                category = categoryService.saveComum(newCategory);
            }
        } else {
            Category newCategory = new Category();
            newCategory.setName("Categoria (Padrão)");
            newCategory.setApplication(applicationService.findById(applicationId).get());

            category = categoryService.saveComum(newCategory);
        }
        event.setCategory(category);

        Event eventPersist = eventRepository.save(event);
        return MapperUtils.instance().map(eventPersist, EventVO.class);
    }

    @Override
    public EventVO delete(Long id) {
        Optional<Event> event = validarDadosDeletarEvento(id);
        eventRepository.deleteById(id);
        EventVO eventVO = null;
        if (event.isPresent())
            eventVO = MapperUtils.instance().map(event.get(), EventVO.class);

        return eventVO;
    }

    @Override
    public EventVO delete(Event event) {
        validarDadosDeletarEvento(event);
        eventRepository.delete(event);
        EventVO eventVO = null;

        return Utils.map(event, EventVO.class);
    }


    @Override
    public EventVO delete(EventVO eventVo) {
        validarDadosDeletarEvento(eventVo);
        Event event = MapperUtils.instance().map(eventVo, Event.class);
        delete(event);

        return eventVo;
    }

    @Override
    public List<EventVO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }


    @Override
    public List<EventVO> findAllFromUser(UserVO userVO) {
        validarUsuario(userVO);
        User user = MapperUtils.instance().map(userVO, User.class);
        List<Event> events = eventRepository.findAllFromUser(user.getId());
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventVO> findAllFromUserById(Long id) {

        List<Event> events = eventRepository.findAllFromUser(id);
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }

    @Override
    public int findEventsCount(EventFilterDto filter) {
        return eventRepositoryHibernate.findEventsCount(filter);
    }

    @Override
    public List<EventVO> findAllFromUser(User user) {
        validarUsuario(user);
        List<Event> events = eventRepository.findAllFromUser(user.getId());
        return events.stream().map(event -> MapperUtils.instance().map(event, EventVO.class)).collect(Collectors.toList());
    }




    /*VALIDATES*/

    private void validarDadosDeletarEvento(EventVO eventVO) {
        if (eventVO == null) {
            throw new NullObjectException("Event object was null");
        }


    }

    private void validarDadosDeletarEvento(Event event) {

        if (event == null) {
            throw new NullObjectException("Event object was null");
        }


    }

    private Optional<Event> validarDadosDeletarEvento(Long id) {
        if (id == null) {
            throw new NullObjectException("Event id was null");
        }
        Optional<Event> event = findById(id);
        if (!event.isPresent()) {
            throw new NotFoundObjectException(String.format("Event with id: %s was not found", id));
        } else {
            return event;
        }
    }

    private void validarDadosSalvarEvento(Event event) {
        if (Utils.isNullOrWhiteSpace(event.getDescription())) {
            throw new IncompleteFieldsException("Field DESCRIPTION not defined or null in Event");
        } else if (Utils.isNullOrWhiteSpace(event.getDetails())) {
            throw new IncompleteFieldsException("Field DETAILS not defined or null in Event");
        } else if (Utils.isNullOrWhiteSpace(event.getSource())) {
            throw new IncompleteFieldsException("Field SOURCE not defined or null in Event");
        } else if (event.getEnvironment() == null) {
            throw new IncompleteFieldsException("Field ENVIRONMENT not defined Event");
        } else if (event.getApplication() == null) {
            throw new NullObjectException("Application object cannot be null");
        } else if (event.getApplication().getId() == null) {
            throw new IncompleteFieldsException("Field ID not defined or null in Application from Event");
        }

        validarApplication(event.getApplication());
    }

    private void validarApplication(Application application) {
        if (application == null) {
            throw new NullObjectException("Application object cannot be null");
        } else if (application.getId() == null) {//response.setHeader("Access-Control-Allow-Origin", req.get);
            throw new IncompleteFieldsException("Field ID not defined or null in Application");
        }


        Optional<Application> applicationResponse = applicationService.findById(application.getId());
        if (!applicationResponse.isPresent()) {
            throw new NotFoundObjectException(String.format("Application with id: %s was not found", application.getId()));
        }
    }

    private void validarUsuario(UserVO userVO) {
        if (userVO == null) {
            throw new NullObjectException("UserVO object cannot be null");
        } else if (userVO.getId() == null) {
            throw new IncompleteFieldsException("Field id not defined or null in UserVO");
        }
    }

    private void validarUsuario(User user) {
        if (user == null) {
            throw new NullObjectException("User object cannot be null");
        } else if (user.getId() == null) {
            throw new IncompleteFieldsException("Field id not defined or null in User");
        }
    }

    private void validarIdRequestUsuario(Long id) {
        if (id == null) {
            throw new NullObjectException("User id was null");
        }
    }
    private void validarIdRequestEvent(Long id) {
        if (id == null) {
            throw new NullObjectException("User id was null");
        }
    }
}

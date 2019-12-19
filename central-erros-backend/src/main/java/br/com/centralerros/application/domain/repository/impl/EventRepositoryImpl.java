package br.com.centralerros.application.domain.repository.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.repository.EventRepository;
import br.com.centralerros.application.utils.Utils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Event> findEvents(EventFilterDto filter) {
        String sql = getSqlForQuery(filter);
        TypedQuery<Event> query = em.createQuery(sql, Event.class);
        setParameters(query, filter);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Event save(Event event) {
        em.persist(event);
        return em.find(Event.class, event.getId());
    }

    private void setParameters(TypedQuery<Event> query, EventFilterDto filter) {
        if(filter.getId() != null && filter.getId() > 0){
            query.setParameter("id", filter.getId());
        }else{
            if(!Utils.isNullOrWhiteSpace(filter.getDescription())){
                query.setParameter("description", filter.getDescription());
            }
            if(!Utils.isNullOrWhiteSpace(filter.getSource())){
                query.setParameter("source", filter.getSource());
            }
            if(!Utils.isNullOrWhiteSpace(filter.getDetails())){
                query.setParameter("details", filter.getDetails());
            }
            if(filter.getStatus() != null && filter.getStatus().getValue() > 0){
                query.setParameter("status", filter.getStatus().getValue());
            }
            if(filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0){
                query.setParameter("environment", filter.getEnvironment().getValue());
            }
            if(filter.getLevel() != null && filter.getLevel().getValue() > 0){
                query.setParameter("level", filter.getLevel().getValue());
            }
            if(filter.getCategory() != null && filter.getCategory().getValue() > 0){
                query.setParameter("category", filter.getCategory().getValue());
            }
            if(filter.getCreateDateStart() != null){
                query.setParameter("createDateStart", filter.getCreateDateStart());
            }
            if(filter.getCreateDateEnd() != null){
                query.setParameter("createDateEnd", filter.getCreateDateEnd());
            }
            if(filter.getUserId() > 0){
                query.setParameter("userId", filter.getUserId());
            }
        }

        if(filter.getPageSize() > 0 && filter.getPage() > 0){
            query.setFirstResult((filter.getPage() - 1) * filter.getPageSize());
            query.setMaxResults(filter.getPageSize());
        }
    }
    
    private String getSqlForQuery(EventFilterDto filter){
        String sql = "SELECT e FROM event as e JOIN e.user u WHERE";

        if(filter.getId() != null && filter.getId() > 0){
            sql += " AND e.id = :id";
        }else{
            if(!Utils.isNullOrWhiteSpace(filter.getDescription())){
                sql += " AND e.description = :description";
            }
            if(!Utils.isNullOrWhiteSpace(filter.getSource())){
                sql += " AND e.source = :source";
            }
            if(!Utils.isNullOrWhiteSpace(filter.getDetails())){
                sql += " AND e.details = :details";
            }
            if(filter.getStatus() != null && filter.getStatus().getValue() > 0){
                sql += " AND e.status = :status";
            }
            if(filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0){
                sql += " AND e.environment = :environment";
            }
            if(filter.getLevel() != null && filter.getLevel().getValue() > 0){
                sql += " AND e.level = :level";
            }
            if(filter.getCategory() != null && filter.getCategory().getValue() > 0){
                sql += " AND e.category = :category";
            }
            if(filter.getCreateDateStart() != null){
                sql += " AND e.create_date >=:createDateStart";
            }
            if(filter.getCreateDateEnd() != null){
                sql += " AND e.create_date <=:createDateEnd";
            }
            if(filter.getUserId() > 0){
                sql += " AND u.id =:userId";
            }
        }

        return sql.replace("WHERE AND","WHERE");
    }
}

package br.com.centralerros.application.domain.repository.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    private void setParameters(TypedQuery<Event> query, EventFilterDto filter) {
        if(filter.getId() > 0){
            query.setParameter("id", filter.getId());
        }else{
            if(filter.getDescription().isEmpty()){
                query.setParameter("description", filter.getDescription());
            }
            if(filter.getSource().isEmpty()){
                query.setParameter("source", filter.getSource());
            }
            if(filter.getDetails().isEmpty()){
                query.setParameter("details", filter.getDetails());
            }
            if(filter.getStatus().getValue() > 0){
                query.setParameter("status", filter.getStatus().getValue());
            }
            if(filter.getEnvironment().getValue() > 0){
                query.setParameter("environment", filter.getEnvironment().getValue());
            }
            if(filter.getLevel().getValue() > 0){
                query.setParameter("level", filter.getLevel().getValue());
            }
            if(filter.getCategory().getValue() > 0){
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
            query.setFirstResult(filter.getPage() * filter.getPageSize());
            query.setMaxResults(filter.getPageSize());
        }
    }
    
    private String getSqlForQuery(EventFilterDto filter){
        String sql = "SELECT e.* FROM event e WHERE 1 ";

        if(filter.getId() > 0){
            sql += " AND id = :id";
        }else{
            if(filter.getDescription().isEmpty()){
                sql += " AND e.description = :description";
            }
            if(filter.getSource().isEmpty()){
                sql += " AND e.source = :source";
            }
            if(filter.getDetails().isEmpty()){
                sql += " AND e.details = :details";
            }
            if(filter.getStatus().getValue() > 0){
                sql += " AND e.status = :status";
            }
            if(filter.getEnvironment().getValue() > 0){
                sql += " AND e.environment = :environment";
            }
            if(filter.getLevel().getValue() > 0){
                sql += " AND e.level = :level";
            }
            if(filter.getCategory().getValue() > 0){
                sql += " AND e.category = :category";
            }
            if(filter.getCreateDateStart() != null){
                sql += " AND e.create_date >= :createDateStart";
            }
            if(filter.getCreateDateEnd() != null){
                sql += " AND e.create_date <= :createDateEnd";
            }
            if(filter.getUserId() > 0){
                sql += " AND e.user_id = :userId";
            }
        }

        return sql;
    }
}

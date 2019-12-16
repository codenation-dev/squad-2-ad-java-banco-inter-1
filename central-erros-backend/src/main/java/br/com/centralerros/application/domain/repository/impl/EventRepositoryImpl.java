package br.com.centralerros.application.domain.repository.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.repository.EventRepository;
<<<<<<< Updated upstream
import br.com.centralerros.application.utils.Utils;
=======
import br.com.centralerros.application.utils.StringUtils;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    @Override
    @Transactional
    public Event save(Event event) {
        em.persist(event);
        return em.find(Event.class, event.getId());
    }
>>>>>>> Stashed changes

    private void setParameters(TypedQuery<Event> query, EventFilterDto filter) {
        if(filter.getId() != null && filter.getId() > 0){
            query.setParameter("id", filter.getId());
        }else{
            if(!StringUtils.isNullOrWhiteSpace(filter.getDescription())){
                query.setParameter("description", filter.getDescription());
            }
<<<<<<< Updated upstream
            if(!Utils.isNullOrEmpty(filter.getSource())){
                query.setParameter("source", filter.getSource());
            }
            if(!Utils.isNullOrEmpty(filter.getDetails())){
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
=======
            if(!StringUtils.isNullOrWhiteSpace(filter.getSource())){
                query.setParameter("source", filter.getSource());
            }
            if(!StringUtils.isNullOrWhiteSpace(filter.getDetails())){
                query.setParameter("details", filter.getDetails());
            }
            if(filter.getStatus() != null && filter.getStatus().getValue() > 0){
                query.setParameter("status", filter.getStatus());
            }
            if(filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0){
                query.setParameter("environment", filter.getEnvironment());
            }
            if(filter.getLevel() != null && filter.getLevel().getValue() > 0){
                query.setParameter("level", filter.getLevel());
            }
            if(filter.getCategory() != null && filter.getCategory().getValue() > 0){
                query.setParameter("category", filter.getCategory());
>>>>>>> Stashed changes
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
        String sql = "SELECT e FROM event e WHERE";

        if(filter.getId() != null && filter.getId() > 0){
<<<<<<< Updated upstream
            sql += " AND id = :id";
        }else{
            if(!Utils.isNullOrEmpty(filter.getDescription())){
                sql += " AND e.description = :description";
            }
            if(!Utils.isNullOrEmpty(filter.getSource())){
                sql += " AND e.source = :source";
            }
            if(!Utils.isNullOrEmpty(filter.getDetails())){
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
=======
            sql += " id =:id";
        }else{
            if(!StringUtils.isNullOrWhiteSpace(filter.getDescription())){
                sql += " AND e.description =:description";
            }
            if(!StringUtils.isNullOrWhiteSpace(filter.getSource())){
                sql += " AND e.source =:source";
            }
            if(!StringUtils.isNullOrWhiteSpace(filter.getDetails())){
                sql += " AND e.details =:details";
            }
            if(filter.getStatus() != null && filter.getStatus().getValue() > 0){
                sql += " AND e.status =:status";
            }
            if(filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0){
                sql += " AND e.environment =:environment";
            }
            if(filter.getLevel() != null && filter.getLevel().getValue() > 0){
                sql += " AND e.level =:level";
            }
            if(filter.getCategory() != null && filter.getCategory().getValue() > 0){
                sql += " AND e.category =:category";
>>>>>>> Stashed changes
            }
            if(filter.getCreateDateStart() != null){
                sql += " AND e.create_date >=:createDateStart";
            }
            if(filter.getCreateDateEnd() != null){
                sql += " AND e.create_date <=:createDateEnd";
            }
            if(filter.getUserId() > 0){
                sql += " AND e.user_id =:userId";
            }
        }

        return sql.replace("WHERE AND","WHERE");
    }
}

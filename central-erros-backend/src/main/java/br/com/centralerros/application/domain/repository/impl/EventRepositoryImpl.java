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
            if(filter.getCategory() != null){
                query.setParameter("category", filter.getCategory().getValue());
            }

            if(filter.getDescription() != null && filter.getDescription() != ""){
                query.setParameter("", filter.getDescription());
            }
        }

        if(filter.getPageSize() > 0 && filter.getPage() > 0){
            query.setFirstResult(filter.getPage() * filter.getPageSize());
            query.setMaxResults(filter.getPageSize());
        }
    }

    String getSqlForQuery(EventFilterDto filter){
        String sql = "SELECT e.* FROM event e WHERE 1 ";

        if(filter.getId() > 0){
            sql += " AND id = :id";
        }else{
            if(filter.getDescription() != null && filter.getDescription() != ""){

            }
            if(filter.getCategory() != null){

            }
            if(filter.getCreateDate() != null){

            }
        }

        return sql;
    }


}

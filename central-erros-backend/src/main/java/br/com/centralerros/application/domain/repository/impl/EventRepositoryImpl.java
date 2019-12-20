package br.com.centralerros.application.domain.repository.impl;

import br.com.centralerros.application.domain.dto.EventFilterDto;
import br.com.centralerros.application.domain.entity.Event;
import br.com.centralerros.application.domain.repository.EventRepository;
import br.com.centralerros.application.utils.Utils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.rmi.CORBA.Util;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Event> findEvents(EventFilterDto filter) {
        String sql = getSqlForQuery(filter, false);
        TypedQuery<Event> query = em.createQuery(sql, Event.class);
        setParameters(query, filter, false);
        return query.getResultList();
    }

    private void setParameters(Query query, EventFilterDto filter, boolean count) {
            if (filter.getId() != null && filter.getId() > 0) {
            query.setParameter("id", filter.getId());
        } else {
            if (!Utils.isNullOrWhiteSpace(filter.getDescription())) {
                query.setParameter("description", filter.getDescription());
            }
            if (!Utils.isNullOrWhiteSpace(filter.getSource())) {
                query.setParameter("source", filter.getSource());
            }
            if (!Utils.isNullOrWhiteSpace(filter.getDetails())) {
                query.setParameter("details", filter.getDetails());
            }
            if (filter.getStatus() != null && filter.getStatus().getValue() > 0) {
                query.setParameter("status", filter.getStatus());
            }
            if (filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0) {
                query.setParameter("environment", filter.getEnvironment());
            }

            if (filter.getLevel() != null && filter.getLevel().getValue() > 0) {
                query.setParameter("level", filter.getLevel());
            }

            if (filter.getCategory() != null) {
                if (filter.getCategory().getId() != null && filter.getCategory().getId() > 0) {
                    query.setParameter("categoryId", filter.getCategory().getId());
                } else if (!Utils.isNullOrWhiteSpace(filter.getCategory().getName())) {
                    query.setParameter("categoryName", filter.getCategory().getName());
                }
            }

            if (filter.getCreateDateStart() != null) {
                query.setParameter("createDateStart", filter.getCreateDateStart());
            }
            if (filter.getCreateDateEnd() != null) {
                query.setParameter("createDateEnd", filter.getCreateDateEnd());
            }
            if (filter.getUserId() != null && filter.getUserId() > 0) {
                query.setParameter("userId", filter.getUserId());
            }
        }

        if (filter.getPageSize() > 0 && filter.getPage() > 0 && !count) {
            query.setFirstResult((filter.getPage() - 1) * filter.getPageSize());
            query.setMaxResults(filter.getPageSize());
        }
    }

    private String getSqlForQuery(EventFilterDto filter, boolean count) {
        String sql = "SELECT " + (count ? "COUNT(e)" : "e")
                + " FROM event as e JOIN e.user u WHERE";

        if (filter.getId() != null && filter.getId() > 0) {
            sql += " AND e.id = :id ";
        } else {
            if (!Utils.isNullOrWhiteSpace(filter.getDescription())) {
                sql += " AND e.description = :description ";
            }
            if (!Utils.isNullOrWhiteSpace(filter.getSource())) {
                sql += " AND e.source = :source ";
            }
            if (!Utils.isNullOrWhiteSpace(filter.getDetails())) {
                sql += " AND e.details = :details ";
            }
            if (filter.getStatus() != null && filter.getStatus().getValue() > 0) {
                sql += " AND e.status = :status ";
            }
            if (filter.getEnvironment() != null && filter.getEnvironment().getValue() > 0) {
                sql += " AND e.environment = :environment ";
            }
            if (filter.getLevel() != null && filter.getLevel().getValue() > 0) {
                sql += " AND e.level = :level ";
            }
            if (filter.getCategory() != null) {
                if (filter.getCategory().getId() != null && filter.getCategory().getId() > 0) {
                    sql += " AND e.category.id = :categoryId ";
                } else if (!Utils.isNullOrWhiteSpace(filter.getCategory().getName())) {
                    sql += " AND e.category.name = :categoryName ";
                }
            }
            if (filter.getCreateDateStart() != null) {
                sql += " AND e.createDate >=:createDateStart ";
            }
            if (filter.getCreateDateEnd() != null) {
                sql += " AND e.createDate <=:createDateEnd ";
            }
            if (filter.getUserId() != null && filter.getUserId() > 0) {
                sql += " AND u.id =:userId ";
            }
        }

        return sql.replace("WHERE AND", "WHERE");
    }

    public int findEventsCount(EventFilterDto filter) {
        String sql = getSqlForQuery(filter, true);
        Query query = em.createQuery(sql);
        setParameters(query, filter, true);
        return query.getSingleResult() != null
                ? Integer.parseInt(query.getSingleResult().toString())
                : 0;
    }
}

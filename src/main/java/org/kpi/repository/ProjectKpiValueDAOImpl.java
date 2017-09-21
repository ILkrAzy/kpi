package org.kpi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.kpi.model.ProjectKpiValue;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author vquochuy
 * @since 9/20/2017
 */
@Transactional
@Repository
public class ProjectKpiValueDAOImpl implements ProjectKpiValueDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProjectKpiValue> getListKpiValueByMonth(int projectId, int month) {
        String sqlQuery = "select * from project_kpi_value where project_id = ? and month = ?";
        Query q = entityManager.createNativeQuery(sqlQuery,
                ProjectKpiValue.class);
        q.setParameter(1, projectId);
        q.setParameter(2, month);
        return q.getResultList();
    }

    @Override
    public void add(ProjectKpiValue projectKpiValue) {
        entityManager.persist(projectKpiValue);
    }

}

package org.kpi.service.impl;

import java.util.List;

import org.kpi.model.ProjectKpiValue;
import org.kpi.repository.ProjectKpiValueDAO;
import org.kpi.service.ProjectKpiValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author vquochuy
 * @since 9/20/2017
 */
@Service
public class ProjectKpiValueServiceImpl implements ProjectKpiValueService {
    private ProjectKpiValueDAO projectKpiValueDAO;

    @Autowired
    public ProjectKpiValueServiceImpl(ProjectKpiValueDAO projectKpiValueDAO) {
        this.projectKpiValueDAO = projectKpiValueDAO;
    }

    @Override
    public void save(ProjectKpiValue projectKpiValue) {
        projectKpiValueDAO.add(projectKpiValue);
    }

    @Override
    public List<ProjectKpiValue> getListKpiValueByMonth(int projectId, int month) {
        return projectKpiValueDAO.getListKpiValueByMonth(projectId, month);
    }

}

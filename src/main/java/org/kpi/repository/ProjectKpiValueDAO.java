package org.kpi.repository;

import java.util.List;

import org.kpi.model.ProjectKpiValue;

public interface ProjectKpiValueDAO {
    List<ProjectKpiValue> getListKpiValueByMonth(int projectId, int month);
    
    void add(ProjectKpiValue projectKpiValue);
}
